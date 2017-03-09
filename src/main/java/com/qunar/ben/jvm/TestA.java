package com.qunar.ben.jvm;

/**
 * Created by ben on 2017/3/8.
 */

public class TestA{
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main(String[] args){
        System.out.println("cnt =" + cnt);
    }
    static{
        cnt /=3;
    };
}