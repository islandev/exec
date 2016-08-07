package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/7.
 * wait 是 运行-> 等待(阻塞)  yield 运行->就绪
 * wait 释放锁 yield 不释放锁
 */
public class YieldLockTest {
    private static Object obj = new Object();


    public static void main(String[] args){
        ThreadC t1 = new ThreadC("t1");
        ThreadC t2 = new ThreadC("t2");

        t1.start();
        t2.start();
    }

    static class ThreadC extends Thread {
        public ThreadC(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (obj) {
                for (int i = 0; i < 10; i++) {
                    System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i);
                    // i整除4时，调用yield
                    if (i % 4 == 0)
                        Thread.yield();
                }
            }
        }
    }
}
