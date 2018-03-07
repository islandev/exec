package com.qunar.ben.leetcode;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/7.
 */

public class RoamNumber {


  private static final Logger logger = LoggerFactory.getLogger(RoamNumber.class);


  public int romanToInt(String s) {
    HashMap<String, Integer> roamMap = new HashMap<String, Integer>() {
      {
        put("M", 1000);
        put("D", 500);
        put("C", 100);
        put("L", 50);
        put("X", 10);
        put("V", 5);
        put("I", 1);
      }
    };
    int roamVal = 0;
    char[] chars = s.toCharArray();
    int length = chars.length;
    for (int i=0;i<length;i++){

    }
    return roamVal;
  }


  public ListNode reverser(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    head = pre;

    return head;
  }

}