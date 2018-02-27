package com.qunar.ben.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/1/23.
 */

public class DeleteDup {

  public class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  private static final Logger logger = LoggerFactory.getLogger(DeleteDup.class);

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dis = new ListNode(0);
    ListNode cur = head;
    while (cur.next!=null){
      if(cur.val!=cur.next.val){
        dis.next=cur;
      }
    }

    return null;
  }
}