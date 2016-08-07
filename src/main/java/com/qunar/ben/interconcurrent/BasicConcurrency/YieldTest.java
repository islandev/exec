package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/7.
 * yield 让步, 当前进程从运行状态 转为 就绪状态,使具有相同的状态的 进程转为运行状态,但不
 * 保证一定在运行
 */


 class  ThreadB extends  Thread{
    public  ThreadB(String name){
        super(name);
    }

    @Override
    public synchronized void run() {



            for (int i = 0; i < 15; i++) {
                System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                if(i%4==0) Thread.yield();
            }

    }
}

public class YieldTest {
    public  static  void main(String[] args){
        ThreadB t1 = new ThreadB("t1");

        ThreadB t2 = new ThreadB("t2");

        t1.start();
        t2.start();

    }
}
