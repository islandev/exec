package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/8.
 */

class Depot {

    private int capacity;
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
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


    public  synchronized  void consume(int val){
        try{
            int left = val;
            while(left>0){
                while(size<= 0) wait();
                int dec = size<left?size:left;
                size-=dec;
                val-=dec;
                System.out.printf("%s consume(%3d) --> left=%3d, inc=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);

                notifyAll();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}

public class ProducerConsumer {
}
