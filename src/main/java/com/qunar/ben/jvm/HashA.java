package com.qunar.ben.jvm;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by ben on 2017/3/7.
 */
public class HashA {
    public static void main(String[] args) {
        Integer a =100;
        String s ="fhsdkfgksdfjgs;";
        int h;
        h = (h = s.hashCode()) ^ (h >>> 16);
        System.out.println(s.hashCode());
        System.out.print(h);
    }
}
