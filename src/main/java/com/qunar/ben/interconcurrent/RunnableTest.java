package com.qunar.ben.interconcurrent;

import java.util.TreeMap;

/**
 * Created by ben on 16/8/5.
 */
public class RunnableTest {
    public  static  void main(String[] args){
        MyThread mt= new MyThread();
        Thread t1= new Thread(mt);
        Thread t2= new Thread(mt);
        Thread t3= new Thread(mt);

        t1.start();

        t2.start();
        t3.start();
    }
}
