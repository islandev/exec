package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/5.
 */
public class WaitTest {
    public  static  void main(String[] args){
        ThreadA t1 = new ThreadA("ta");
        synchronized (t1){
        try{
            System.out.println(Thread.currentThread().getName() + " start ");
            t1.start();

            System.out.println(Thread.currentThread().getName() + "  wait");
            t1.wait();

        }catch (Exception e){
            e.printStackTrace();
        }
        }

    }
}


class  ThreadA extends Thread{
    public  ThreadA(String name){
        super(name);
    }


    public  void  run(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName() + " call notify");
            this.notify();
        }
    }
}