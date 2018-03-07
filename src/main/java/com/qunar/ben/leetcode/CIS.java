package com.qunar.ben.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/7.
 */

public class CIS {


  private static final Logger logger = LoggerFactory.getLogger(CIS.class);

  public int findLengthOfLCIS(int[] nums) {
    int cisLength = 1;
    int maxLength = 1;
    int length = nums.length;
    if (length <= 1) {
      return length;
    }
    for (int i = 1; i < length; i++) {
      if (nums[i - 1] < nums[i]) {
        cisLength++;
        if (cisLength > maxLength) {
          maxLength = cisLength;
        }
      } else {
        cisLength = 1;
      }
    }
    return maxLength;
  }
}