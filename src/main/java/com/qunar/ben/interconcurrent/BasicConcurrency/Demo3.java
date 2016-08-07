package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/8.
 */

class  MyThreadA extends Thread{
    private volatile boolean flag = true;

    public  void stopTask(){
        flag = false;
    }

    public  MyThreadA(String name){
        super(name);
    }

    public  void run(){
        synchronized (this){
            try{
                int i=0;
                while (flag){
                    Thread.sleep(100);
                    i++;
                    System.out.println(Thread.currentThread().getName()+" ("+this.getState()+") loop " + i);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class Demo3  {
    public  static void  main(String[] args){
        try{
            MyThreadA t1 = new MyThreadA("t1");
            System.out.println(t1.getName() +" ("+t1.getState()+") is new.");

            t1.start();

            System.out.println(t1.getName() +" ("+t1.getState()+") is start.");

            Thread.sleep(300);
            t1.stopTask();
            System.out.println(t1.getName() +" ("+t1.getState()+") is 打断.");

            Thread.sleep(300);
            System.out.println(t1.getName() +" ("+t1.getState()+")现在中断了");


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
