package com.qunar.ben.interconcurrent.blockqueye;

import java.util.concurrent.BlockingQueue;

/**
 * Created by ben on 16/8/7.
 */
public class Consumer implements  Runnable {

    protected BlockingQueue queue = null;

    public  Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        try{
            for(int i =0 ; i<5;i++){
                System.out.println(queue.take());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
