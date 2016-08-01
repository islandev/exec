package com.qunar.ben.leetcode;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by ben on 16/8/1.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchForARange {

    public  static List<Integer> searchRange(int[] nums, int target) {
        int  low = 0;
        int high = nums.length -1 ;
        ArrayList<Integer> indexVal= new ArrayList<Integer>();
        BinarySearchR(low,high,nums,target);

        return  indexVal;

    }
    public  static  void BinarySearchR(int start, int end , int[] num, int target){
        while(start<end){
            int mid = (start +end)/2;
            if(target >num[mid]) BinarySearchR(mid,end,num,target);
            if(target<num[mid])  BinarySearchR(start,mid,num,target);
            if(target == num[mid]){
                System.out.println(mid);
             if(mid+1<end)   BinarySearchR(mid+1,end,num,target);
             if(mid-1>start)   BinarySearchR(start,mid-1,num,target);
            }

        }
    }

    public static void main(String[] args){
        int[] nums = {5, 7, 7, 8,8, 8, 10};
        int target = 8 ;
        List<Integer> range= searchRange(nums,target);

    }

}