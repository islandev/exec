package com.qunar.ben.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/7.
 */

public class ReverseInteger {


  private static final Logger logger = LoggerFactory.getLogger(ReverseInteger.class);

  /**
   * 主要是考虑溢出的 不相等 代表溢出 return 0
   * @param x
   * @return
   */
  public static int reverse(int x) {
    int res = 0;
    while (x != 0) {
      int tail = x % 10;
      int newRes = res * 10 + tail;
      if ((newRes - tail) / 10 != res) {
        return 0;
      }
      res = newRes;
      x /= 10;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.printf(String.valueOf(reverse(1534236469)));
  }

}