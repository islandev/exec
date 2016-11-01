package com.qunar.ben.interconcurrent.JUCLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ben on 16/8/8.
 */



class Depot {

    private int capacity;
    private int size;

    private  Lock lock;
    public Depot(int capacity) {
        this.capacity = capacity;
        this.lock =  new ReentrantLock();
        this.size = 0;
    }

    public synchronized void produce(int val) {
        try {
            int left = val;
            while (left > 0) {
                while (size >= capacity) wait();
                //获取增量数据
                int inc = (left + size) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;

                System.out.printf("%s produce(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                notifyAll();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public synchronized void consume(int val) {
        try {
            int left = val;
            while (left > 0) {
                while (size <= 0) wait();
                int dec = (size < left )? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) --> left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);

                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String toString() {
        return "capacity :" + capacity + ",actual size:" + size;
    }
}

class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot.produce(val);
            }
        }.start();
    }

}


class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consume(int val) {
        new Thread() {
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}

public class LockTest1 {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Consumer mCus = new Consumer(mDepot);
        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}


