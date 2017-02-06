package com.qunar.ben.leetcode;

import com.google.common.base.Splitter;
import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.Interceptor;

import java.util.List;

/**
 * Created by ben on 2017/1/9.
 */
public class RevertBits {

        // you need treat n as an unsigned value
        public   static int reverseBits(int n){
            char[] byteArray =  Integer.toBinaryString(n).toCharArray();

            for (char b:byteArray){
                System.out.println(b);
            }

            return  0;
        }

        public  static void main(String[] args){
            reverseBits(1024);
        }

}
