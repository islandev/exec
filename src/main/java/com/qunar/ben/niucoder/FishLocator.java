package com.qunar.ben.niucoder;

import java.io.Console;

/**
 * Created by ben on 2017/3/9.
 */
public class FishLocator {
    public static void main(String[] args) {
        Console console = System.console();
        try {
            String str = console.readLine();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public  static  int   fishLocator(int max,int min,int n ,int[] fishSizes){
        int count = 0;
        for(int i=min;i<max;i++){
            boolean flag = true;
            for (int fishSize:fishSizes){
                if(i<=fishSize*10&&i>=fishSize*2)  flag=false;
                break;
            }
            if(flag) {
                fishSizes[fishSizes.length] = i;
                count++;
            }

        }
        return  count;
    }
}
