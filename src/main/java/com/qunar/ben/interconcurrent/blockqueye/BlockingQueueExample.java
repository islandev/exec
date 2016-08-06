package com.qunar.ben.interconcurrent.blockqueye;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by ben on 16/8/7.
 */
public class BlockingQueueExample {

    public  static  void main(String[] args) throws  Exception{
        BlockingQueue queue =new ArrayBlockingQueue(1024);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
