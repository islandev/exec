package com.qunar.ben.leetcode;

import javax.print.attribute.standard.RequestingUserName;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/1.
 * 最大支持2^31-1的数
 */
public class NumberToWords {
    public final static  HashMap<Integer,String>  numberMap = new HashMap<Integer, String>(){
        {
            put(0,"zero");
            put(1,"one");
            put(2,"two");
            put(3,"three");
            put(4,"four");
            put(5,"five");
            put(6,"six");
            put(7,"seven");
            put(8,"eight");
            put(9,"nine");
        }
    };

    public  final  static  HashMap<Integer,String> unitMap = new HashMap<Integer, String>(){
        {
            put(1,"hundred");
            put(2,"thousand");
            put(3,"billion");
            put(4,"million");
        }
    };

    public  static  String  number2String(int num){
        String originNum = String.valueOf(num);
        int l = originNum.length()-1;
        int i = l ;
        int count;
        while(i<=l){
            count =0 ;

        }
        System.out.println(originNum);
        return  "";
    }
    public static  void main(String[] args){
        int num = 1234567890;
        number2String(num);
    }
}
