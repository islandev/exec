package com.qunar.ben.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/13.
 */

public class ClimbStairs {

  private static final Logger logger = LoggerFactory.getLogger(ClimbStairs.class);

  public static int climbStairs(int n) {
    if (n <= 2) {
      return n;
    }

    int pre = 1;
    int cur = 2;
    int ans = 0;
    int i = 3;
    while (i <= n) {
      ans = pre + cur;
      pre = cur;
      cur = ans;
      i++;
    }
    return ans;
  }

  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    int curVal = head.val;
    ListNode pre = head;
    ListNode cur = head.next;
    while (cur != null) {
      if (cur.val == curVal) {
        pre.next = cur.next;
        cur = cur.next;
      } else {
        curVal = cur.val;
        pre = cur;
        cur = cur.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    System.out.printf(String.valueOf(climbStairs(25)));
  }


  public void mergeAC(int A[], int m, int B[], int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i > -1 && j > -1) {
      A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
    }
    while (j > -1) {
      A[k--] = B[j--];
    }
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null || p.val != q.val) {
      return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lDepth = maxDepth(root.left);
    int rDepth = maxDepth(root.right);
    return Math.max(lDepth, rDepth) + 1;
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (queue.size() > 0) {
      List<Integer> sub = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sub.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      res.add(0, sub);

    }

    return res;
  }

  public TreeNode sortedArrayToBST(int[] nums) {

    return null;
  }


}

