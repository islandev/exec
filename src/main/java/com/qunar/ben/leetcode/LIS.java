package com.qunar.ben.leetcode;

/**
 * Created by ben on 2017/2/8.
 * 最长递增子序列
 */
public class LIS {
    public  static  int GetLIS(int[] arr){
        int l = arr.length;
        int[] lisArr = new int[l];
        lisArr[0] = 1;

        int  lis = 1;
        for(int i=1;i<l;i++){
            int max =1;
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j]) max =max> (lisArr[j]+1)? max:(lisArr[j]+1);
            }
            lisArr[i] = max;
            lis = max > lis ? max :lis;

        }

        return  lis;
    }

    public  static  int LISOpt(int[] arr){
        int l = arr.length;
        int[] b = new int[l];
        b[0] = arr [0];
        int lis =0;
        for (int i=1;i<l;i++){

        }
        return  lis;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{5,6,7,1, 2,8};
        System.out.println(GetLIS(arr));

    }
}
