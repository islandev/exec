package com.qunar.ben.leetcode;

import java.util.*;


/**
 * Created by ben on 16/8/2.
 */
public class LimitBonus {
    public  static  List<Double> limitBonus(double sum , int num , int maxVal , int minVal){
        List<Double> bonusList = new ArrayList<>();
        for(int i=num;i>=1;i--){
            double min = (sum-(maxVal*(i-1)))>minVal?(sum-(maxVal*(i-1))):minVal;
            double max = (sum-(minVal*(i-1)))<maxVal?(sum-(minVal*(i-1))):maxVal;
            double randomVal =(double) Math.round((Math.random()*(max-min)+min)*100)/100;
            bonusList.add(randomVal);
            sum -= randomVal;
        }
        return  bonusList;
     }

    public   static  void main(String[] args){
        List<Double> blist = limitBonus(100,10,12,6);
        for ( double val: blist){
            System.out.println(val);
        }
    }


}
