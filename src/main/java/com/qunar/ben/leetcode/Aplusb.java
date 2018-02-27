package com.qunar.ben.leetcode;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/2/22.
 */

public class Aplusb {

  private static final Logger logger = LoggerFactory.getLogger(Aplusb.class);

  public static int aplusb(int a, int b) {
    int sum = a;
    int carry = b;
    while (carry != 0) {
      int tmp = sum;
      sum = tmp ^ carry;
      carry = (tmp & carry) << 1;
    }
    return sum;
  }


  public ListNode addLists2(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);

    return dummy.next;
    // write your code here
  }

  public static void main(String[] args) {

    int[] ans = {0, 0, 1, 1, 1};
    System.out.printf(String.valueOf(numRabbits(ans)));
  }

  public int minimumTotal(int[][] triangle) {
    // write your code here

    int length = triangle.length;
    int min = 0;

    for (int i = length - 1; i > 0; i--) {

    }
    return min;

  }

  public static int numRabbits(int[] answers) {
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int val : answers) {
      if (countMap.containsKey(val)) {
        countMap.put(val, countMap.get(val) + 1);
      } else {
        countMap.put(val, 1);
      }
    }
    double num = 0;
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
      double cp = Math.ceil((double)entry.getValue() / ((double)entry.getKey() + 1));
      double res = cp * (entry.getKey() + 1);
      num += Math.ceil((double)entry.getValue() / (double) (entry.getKey() + 1)) * (entry.getKey() + 1);
    }
    return (int) num;
  }


}