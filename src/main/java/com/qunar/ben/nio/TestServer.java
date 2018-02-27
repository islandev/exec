package com.qunar.ben.nio;

import com.google.common.base.Strings;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2017/10/27.
 */

public class TestServer implements Runnable {

  private static final Logger logger = LoggerFactory.getLogger(TestServer.class);
  private Selector selector;
  private ServerSocketChannel socketChannel;
  private volatile boolean stop;

  public TestServer(int port) {
    try {
      selector = Selector.open();
      socketChannel = ServerSocketChannel.open();
      socketChannel.configureBlocking(false);
      socketChannel.socket().bind(new InetSocketAddress(port), 1024);
      socketChannel.register(selector, SelectionKey.OP_ACCEPT);
    } catch (IOException e) {

    }
  }

  @Override
  public void run() {
    while (!stop) {
      try {
        selector.select(1000);
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> it = selectionKeys.iterator();
        SelectionKey key;
        while (it.hasNext()) {
          key = it.next();
          it.remove();
          try {

            handleInputKey(key);
          } catch (Exception e) {
            if (key != null) {
              key.cancel();
              if (key.channel() != null) {
                key.channel().close();
              }
            }
          }
        }
      } catch (Throwable throwable) {
        throwable.printStackTrace();
      }
      if (selector != null) {
        try {
          selector.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }


  }

  private void handleInputKey(SelectionKey key) throws IOException {

    if (key.isValid()) {
      if (key.isAcceptable()) {
        ServerSocketChannel serverSocketChannelchannel = (ServerSocketChannel) key.channel();
        SocketChannel accept = serverSocketChannelchannel.accept();
        accept.configureBlocking(false);
        accept.register(selector, SelectionKey.OP_READ);
      }

      if (key.isReadable()) {
        SocketChannel channel = (SocketChannel) key.channel();
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        int read = channel.read(allocate);
        if (read > 0) {
          allocate.flip();
          byte[] bytes = new byte[allocate.remaining()];
          allocate.get(bytes);
          String body = new String(bytes, "UTF-8");
          System.out.println("recv body" + body);
          doWrite(channel, body);
        } else if (read < 0) {
          key.cancel();
          socketChannel.close();
        } else {

        }
      }
    }
  }


  private void doWrite(SocketChannel socketChannel, String response) throws IOException {
    if (!Strings.isNullOrEmpty(response)) {
      byte[] bytes = response.getBytes();
      ByteBuffer allocate = ByteBuffer.allocate(bytes.length);
      allocate.put(bytes);
      allocate.flip();
      socketChannel.write(allocate);
    }
  }
}