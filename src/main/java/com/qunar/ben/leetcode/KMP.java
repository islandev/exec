package com.qunar.ben.leetcode;

import scala.actors.SuspendActorControl;

import java.util.*;

/**
 * Created by ben on 2017/2/6.
 */
public class KMP {
    public  static  int[]  GeneratePMT(String searchChar){
        int[] pmt =  new int[searchChar.length()];
        //存前缀
        Set<String> prefixList = new HashSet<>();
        //存后缀
        Set<String> suffixList = new HashSet<>();

        Set<String> result = new HashSet<>();
        //获取 前缀  后缀  进行比较
        for (int i=0;i<searchChar.length();i++){
            prefixList.clear();
            suffixList.clear();
            if (i>0){
                for (int m=0;m<i;m++){
                    prefixList.add(searchChar.substring(0,m+1));
                    suffixList.add(searchChar.substring(m+1,i+1));
                }

            }

            prefixList.retainAll(suffixList);

            if (prefixList.size()<1){
                pmt[i]=0;
            }else {
                Iterator<String>  it =  prefixList.iterator();
                while (it.hasNext()){
                    pmt[i]=Math.max(pmt[i],it.next().length());
                }
            }


            //System.out.println(prefixList.size(),prefixList.size()+'\t'+result.size());

        }
        for (int i:pmt
             ) {
            System.out.println(i);
        }
        return  pmt;
    }
    //00123401

    public   static  boolean StringMatcher(String src,String dst){
        int[] pmt = GeneratePMT(dst);
        int m = src.length();
        int n = dst.length();
        for(int i=0,j=0; i<m; ++i){
            while (j>0 && src.charAt(i)!=dst.charAt(j)) j=pmt[j-1];
            if(src.charAt(i)==dst.charAt(j)) j++;
            if(j==n) return  true;
        }
        return  false;
    }
    public static void main(String[] args) {
        String  src =  "ABCDAB CD";
        String dst = "AB C";
        boolean match  = StringMatcher(src,dst);
        System.out.println(match);


    }
}
