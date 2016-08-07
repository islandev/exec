package com.qunar.ben.interconcurrent.BasicConcurrency;

/**
 * Created by ben on 16/8/7.
 */
class  ThreadJ extends Thread{
    public  ThreadJ (String name){
        super(name);
    }

    public  void  run(){
        System.out.printf("%s start\n",this.getName());
        for (int i=0;i<100;i++)
            ;
        System.out.printf("%s finish\n", this.getName());

    }
}

public class JoinTest  {
    public  static  void main(String[] args){
        try {
            ThreadJ tj = new ThreadJ("t1");
            tj.start();
            tj.join();
            System.out.printf("%s finish\n", Thread.currentThread().getName());

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
