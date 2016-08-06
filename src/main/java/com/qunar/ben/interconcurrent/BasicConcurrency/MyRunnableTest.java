package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/5.
 */
public class MyRunnableTest implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            try{
            for(int i=0;i<5;i++){
                Thread.sleep(300);
                System.out.println(Thread.currentThread().getName() + "loop "+i );

            }
        } catch (Exception e){
                System.out.println(e);
            }
        }

    }
}

