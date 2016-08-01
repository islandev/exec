package com.qunar.ben.leetcode;

/**
 * Created by ben on 16/8/1.
 */
import java.lang.Math;
public class WiggleSubsequence {

        public static  int wiggleMaxLength(int[] nums) {
            int p = 1 , q = 1 , n = nums.length;
            for(int i=1;i<n;++i){
                if(nums[i]>nums[i-1])  p=q+1;
                else if(nums[i]<nums[i-1]) q=p+1;
            }
            return  Math.min(n,Math.max(p,q));

        }
        public static void main(String[] args){
            int[]  nums = {1,7,4,9,2,5};
            int ml = wiggleMaxLength(nums);
            System.out.println(ml);

        }
}
