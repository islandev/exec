package com.qunar.ben.niucoder;

/**
 * Created by ben on 2017/3/8.
 */

class A{
    public A(String str){

    }
}
public class Edot{
    public static void main(String[] args) {
        A classa=new A("he");
        A classb=new A("he");
        System.out.println(classa==classb);
    }
}