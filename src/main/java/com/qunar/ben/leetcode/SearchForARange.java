package com.qunar.ben.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by ben on 16/8/1.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */
public class SearchForARange {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        //主要左边界
        int start = 0, end = nums.length - 1, mid = 0;
        int[] bound = {0, 0};
        //偏移到临界点
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //根据临界点进行赋值
        if (nums[start] == target) {
            bound[0] = start;
        } else if (nums[end] == target) {
            bound[0] = end;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }

        //偏移到临界点
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        //根据临界点进行赋值
        if (nums[end] == target) {
            bound[1] = end;
        } else if (nums[start] == target) {
            bound[1] = start;
        } else {
            bound[0] = bound[1] = -1;
            return bound;
        }
        return bound;


    }


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 8, 8, 10};
        int target = 8;
        int[] bound = searchRange(nums, target);
        for (int val : bound) {
            System.out.println(val);
        }

    }

}