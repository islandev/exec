package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/5.
 */
class Count {
    public  void   syncCount(){
        synchronized (this){
            try{
                for(int i=0;i<5;i++){
                    Thread.sleep(300);
                    System.out.println(Thread.currentThread().getName()+ "sync count "+i);
                }
            }catch (Exception e){

            }
        }
    }

    public  void unSyncCount(){
        try{
        for(int i=0;i<5;i++){
            Thread.sleep(300);
            System.out.println(Thread.currentThread().getName()+ "sync count "+i);
        }}catch (Exception e){
            System.out.println(e);
        }
    }
}

public  class  Demo{
    public  static  void main(String[] args){
        Count ct = new Count();
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                ct.syncCount();
            }
        });

        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                ct.unSyncCount();
            }
        });

        t1.start();
        t2.start();
    }
}