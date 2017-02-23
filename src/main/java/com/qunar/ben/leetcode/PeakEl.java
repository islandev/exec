package com.qunar.ben.leetcode;

/**
 * Created by ben on 2017/2/23.
 */
public class PeakEl {
    public int findPeakElement(int[] nums) {
        int index =0;
        int l = nums.length;
        if(l>1) {
            if(l==2) return nums[0]>nums[1]?0:1;
            for (int i = 1; i < l ; i++) {

                if (i<l-1&&nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {

                    index=i;
                    break;
                }
                if(i==l-1&&nums[i]>nums[i-1]){
                    index=i;
                    break;
                }
            }
        }
        return  index;
    }
}
