package com.qunar.ben.niucoder;

import java.util.List;

/**
 * Created by ben on 2017/3/9.
 */
public class LoopWords {
    public  static  int  getLoop(int n, List<String> words){
        int  count =0 ;
        for (int i=0;i<n;i++){

        }
        return  0;
    }
    //index=index-offset>0?n-offset:n-offset+length
    public  boolean isLoop(String src, String dst){
        if(src.length()!=dst.length()) return  false;
        int len =  src.length();
        int offset = 0;
        for(int i=0;i<len;i++){
             for (int j=0;j<len;j++)
               if(src.charAt(i)!=dst.charAt(j))  offset++;

            }
        String decodst = dst.substring(len-offset,len)+dst.substring(0,len-offset);
        if(src.equals(decodst)) return true;
        return  false;
        }
        
    }

