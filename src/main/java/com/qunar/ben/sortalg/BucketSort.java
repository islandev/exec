package com.qunar.ben.sortalg;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by ben on 2016/11/2.
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] a = {4,6,2,5,6,8,7,9,1};
        qucikSort(a,0,a.length-1);
        for (int val: a
                ) {
            System.out.println(val);
        }
    }

    public static  void  qucikSort(int[] a, int low, int high){
        int start=low;;
        int end = high;
        int p = a[low];
        if(low<high){
            while(low<high){

                while(low<high&&a[high]>=p) high--;
                a[low]=a[high];
                while(low>high&&a[low]<=p) low++;
                a[high]=a[low];
            }
            a[low]=p;
            qucikSort(a,start,low-1);
            qucikSort(a,low+1,end);
        }
    }



}
