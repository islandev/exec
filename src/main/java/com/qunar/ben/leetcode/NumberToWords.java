package com.qunar.ben.leetcode;

import javax.print.attribute.standard.RequestingUserName;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/8/1.
 * 最大支持2^31-1的数
 * StringBuffer线程安全
 * StringBulder 非线程安全
 * 可以使用map 也可以使用index来标示字段
 */
public class NumberToWords {
    public final static  HashMap<Integer,String>  numberMap = new HashMap<Integer, String>(){
        {   put(0, "");
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
            put(10, "Ten");
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eighteen");
            put(19, "Nineteen");
            put(20, "Twenty");
            put(30, "Thirty");
            put(40, "Forty");
            put(50, "Fifty");
            put(60, "Sixty");
            put(70, "Seventy");
            put(80, "Eighty");
            put(90, "Ninety");
        }
    };

    public  final  static  HashMap<Integer,String> unitMap = new HashMap<Integer, String>(){
        {
            put(0,"hundred");
            put(1,"thousand");
            put(2,"billion");
            put(3,"million");
        }
    };

    public  static  String  number2String(int num){
        if(num==0) return numberMap.get(num);

        int tmp=0;
        int unit=0;
        StringBuilder sb = new StringBuilder();
        if(num>=Math.pow(10,9)){
            int extra = num/(int)Math.pow(10,9);
            sb.append(transfer(extra)).append(" ").append(unitMap.get(3)).append(" ");
            num=num%(int)Math.pow(10,9);
        }
        if(num>=Math.pow(10,6)){
            int extra = num/(int)Math.pow(10,6);
            sb.append(transfer(extra)).append(" ").append(unitMap.get(2)).append(" ");
            num=num%(int)Math.pow(10,6);
        }
        if(num>=Math.pow(10,3)){
            int extra = num/(int)Math.pow(10,3);
            sb.append(transfer(extra)).append(" ").append(unitMap.get(1)).append(" ");
            num=num%(int)Math.pow(10,3);
        }
        sb.append(transfer(num));
        return  sb.toString();
    }
    public static  StringBuilder transfer(int num){

        StringBuilder sb = new StringBuilder();
        if(num/100!=0) {
            sb.append(numberMap.get(num / 100)).append(" ").append("hundred").append(" ");
            num = num%100;
        }
        if(num/10>1){
            sb.append(numberMap.get(num/10*10)).append(" ").append(numberMap.get(num%10)).append(" ");
        }else if(num/10<=1){
            sb.append(numberMap.get(num));
        }
        return sb;
    }
    public static  void main(String[] args){
        int num = 452375902;
       System.out.println( number2String(num));
    }
}
