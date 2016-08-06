package com.qunar.ben.interconcurrent.blockqueye;

import java.util.concurrent.BlockingQueue;

/**
 * Created by ben on 16/8/7.
 */
public class Producer implements Runnable {
    protected BlockingQueue queue = null;

    public  Producer(BlockingQueue queue){
        this.queue = queue;
    }

    public  void run(){
        try{
            for(int i=0;i<5;i++){
                queue.put(String.valueOf(i));
                Thread.sleep(1000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
