package com.qunar.ben.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/8.
 */

public class StrImpl {

  private static final Logger logger = LoggerFactory.getLogger(StrImpl.class);

  public static int strStr(String haystack, String needle) {
    int sLength = haystack.length();
    int dLength = needle.length();
    if (dLength == 0) {
      return 0;
    }
    if (sLength < dLength) {
      return -1;
    }
    for (int i = 0; i <= sLength - dLength; i++) {
      int j;
      for (j = 0; j < dLength; j++) {
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
        if (j == dLength - 1) {
          return i;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
//    System.out.printf(String.valueOf(strStr("mississippi"
////        , "issip")));
    int[] nums = {1, 3, 5, 6};

    // System.out.printf(String.valueOf(searchInsertL(nums, 5)));
    System.out.printf(countAndSay(50));
  }

  public int searchInsert(int[] nums, int target) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      if (nums[i] >= target) {
        return i;
      }
    }
    return length;
  }

  public static int searchInsertL(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int num = nums[mid];
      if (num == target) {
        return mid;
      } else if (num < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static String countAndSay(int n) {

    int count = 1;
    String res = "1";
    while (count++ < n) {
      res = getNext(res);
    }
    return res;
  }

  private static String getNext(String origin) {
    StringBuilder sb = new StringBuilder();
    char curVal = origin.charAt(0);
    int count = 1;
    for (int i = 1; i < origin.length(); i++) {
      if (origin.charAt(i) == curVal) {
        count++;
      } else {
        sb.append(count).append(curVal);
        curVal = origin.charAt(i);
        count = 1;
      }
    }
    sb.append(count).append(curVal);
    return sb.toString();
  }
}