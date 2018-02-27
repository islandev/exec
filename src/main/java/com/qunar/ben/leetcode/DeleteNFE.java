package com.qunar.ben.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/1/31.
 */

public class DeleteNFE {

  private static final Logger logger = LoggerFactory.getLogger(DeleteNFE.class);

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode sec = dummy;

    for (int i = 0; i <= n; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      sec = sec.next;
    }

    sec.next = sec.next.next;

    return dummy.next;
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        cur.next = l1;
        l1 = l1.next;
      } else {
        cur.next = l2;
        l2 = l2.next;
      }
      cur = cur.next;

    }
    if (l1 == null) {
      cur.next = l2;
    }
    if (l2 == null) {
      cur.next = l1;
    }

    return dummy.next;
  }

}