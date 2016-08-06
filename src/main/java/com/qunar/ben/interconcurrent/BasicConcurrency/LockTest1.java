package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/5.
 */

class  Something{
    public  synchronized  void isSyncA(){
        try{
            for(int i=0; i<5;i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+" is SyncA"+i);
            }
        }catch (Exception e){

        }
    }

    public synchronized void isSyncB(){
        try{
            for(int i=0;i<5;i++){
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+" is SyncB " + i);
            }
        }catch (Exception e){

        }
    }
}

public class LockTest1 {



    public static void main(String[] args){
        Something st1= new Something();
        Something st2= new Something();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                st1.isSyncA();
            }
        });

        Thread t2 =  new Thread(new Runnable() {
            @Override
            public void run() {
                st2.isSyncB();
            }
        });

        t1.start();
        t2.start();
    }
}
