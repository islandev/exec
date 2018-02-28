package com.qunar.ben.leetcode;

/**
 * Created by ben.wang on 2018/2/27.
 */

public class MSW {

  public int[] maxSlidingWindow(int[] nums, int k) {

    return null;
  }

  public ListNode removeElements(ListNode head, int val) {
    if (head != null && head.val == val) {
      head = head.next;
    }

    if (head == null) {
      return head;
    }

    ListNode pre = head;
    ListNode cur = head.next;

    while (cur != null) {
      if (cur.val == val) {
        pre.next = cur.next;
        cur = cur.next;
      } else {
        pre = cur;
        cur = cur.next;
      }

    }
    return head;
  }

  public ListNode reverseNOde(ListNode head) {
    return head;
  }
}