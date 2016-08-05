package com.qunar.ben.interconcurrent;

/**
 * Created by ben on 16/8/5.
 */
public class MyThread implements  Runnable  {
    private  int ticket = 10;

    public  void run(){
        for(int i=0;i<20;i++){
            if(this.ticket>0) System.out.println(Thread.currentThread().getName() + "has sold :" +this.ticket-- );
        }
    }

}


