package com.qunar.ben.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/8.
 */

public class MaxSubArray {

  private static final Logger logger = LoggerFactory.getLogger(MaxSubArray.class);

  public static int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int length = nums.length;
    int max = nums[0];
    int cur = nums[0];
    for (int i = 1; i < length; i++) {
      int num = nums[i];
      if (cur + num < num) {
        cur = num;
      } else {
        cur += num;
      }
      if (cur > max) {
        max = cur;
      }
    }

    return max;
  }

  public static int lengthOfLastWord(String s) {

    int length = -1;
    if (s == null || (length = s.length()) == 0) {
      return 0;
    }
    int res = 0;
    int cur = 0;
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        if (cur != 0) {
          res = cur;
        }
        cur = 0;
      } else {
        cur++;
      }
    }
    return cur == 0 ? res : cur;
  }

  public static  int[] plusOne(int[] digits) {
    int length = digits.length;
    int[] resArray = new int[length +1];
    int carry = 1;
    for (int i = length - 1; i >= 0; i--) {
      int res = carry + digits[i];
      carry = res / 10;
      resArray[i + 1] = res % 10;
    }
    if (carry == 1) {
      resArray[0] = 1;
      return resArray;
    }

    int[] ans = new int[length];

    for (int i = 0; i < length; i++) {
      ans[i] = resArray[i +1];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1};
    int[] ints = plusOne(nums);
    System.out.printf("hio");
  }

}