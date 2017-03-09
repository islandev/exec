package com.qunar.ben.jvm;

/**
 * Created by ben on 2017/3/2.
 */
public class StringQ {
    public static void main(String[] args) {
        String a = "a";
        String b ="b";
        b=a;
        System.out.println(b);
        a = "c";
        System.out.println(b);
        System.out.println(a);
    }
}
