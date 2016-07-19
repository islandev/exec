package com.qunar.ben.httpdemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ben on 16/7/18.
 */

public class socketl {

    private   static    final  int  port = 8099;

    public  static void  main(String[] args){

        int counter =1 ;
        try{
            ServerSocket ss = new ServerSocket(port);
            while(true){
                Socket s = ss.accept();
                Thread t = new Thread(new SocketThread(s));
                System.out.print("start"+counter+" socketserver");
                counter++;
                t.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}

