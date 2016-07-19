package com.qunar.ben.httpdemo;



import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by ben on 16/7/18.
 * socket 长连接
 */
public class SocketThread extends Thread {
    private Socket socket;

    public SocketThread (Socket socket){
        this.socket = socket;
    }

    public  void run(){
        System.out.print("a new thread is working" + Thread.currentThread().getId());
        if(socket!= null){
            OutputStream os = null;
            String clientIp = socket.getInetAddress().toString().replace("/","");
            int clientPort = socket.getPort();

            System.out.print(clientIp + ":" + clientPort);
            try{
                socket.setKeepAlive(true);
                os = socket.getOutputStream();

                while (true){
                    Thread.sleep(300);
                    String str = "this is my notify";
                    os.write(str.getBytes());
                    os.flush();
                }
            }catch (Exception e){
                e.printStackTrace();
                try{
                    os.close();
                }catch (Exception el){
                    el.printStackTrace();
                }


            }


        }
    }

}
