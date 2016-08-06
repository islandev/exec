package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/5.
 */
public class SyncRunnableTest {
    public  static  void main(String[] args){
        MyRunnableTest mrt = new MyRunnableTest();

        Thread t1 = new Thread(mrt);
        Thread t2 = new Thread(mrt);

        t1.start();
        t2.start();
    }
}
