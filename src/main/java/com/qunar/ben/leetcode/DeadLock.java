package com.qunar.ben.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/1/23.
 */

public class DeadLock {

  private static final Logger logger = LoggerFactory.getLogger(DeadLock.class);

  public static int openLock(String[] deadends, String target) {
    Queue<String> queue = new LinkedList<>();
    queue.offer("0000");
    queue.offer(null);
    Set<String> dead = new HashSet<>(Arrays.asList(deadends));
    String init = "0000";
    Set<String> seen = new HashSet<>();
    seen.add("0000");
    if (dead.contains(init)) {
      return -1;
    }
    int depth = 0;

    while (!queue.isEmpty()) {
      String node = queue.poll();
      if (node == null) {
        depth++;
        if (queue.peek() != null) {
          // add layer
          queue.offer(null);
        }
      } else if (target.equals(node)) {
        return depth;
      } else if (!dead.contains(node)) {
        for (int i = 0; i < 4; ++i) {
          for (int d = -1; d <= 1; d += 2) {
            int y = ((node.charAt(i) - '0') + d + 10) % 10;
            String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
            if (!seen.contains(nei)) {
              seen.add(nei);
              queue.offer(nei);
            }
          }
        }
      }
    }
    return -1;
  }


  public List<Integer> removeList(List<Integer> src, List<Integer> dst) {
    src.removeAll(dst);
    Iterator<Integer> iterator = src.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      if (dst.contains(next)) {
        iterator.remove();
        dst.remove(next);
      }
    }
    return src;
  }

  public static void main(String[] args) {

    String[] dead = new String[]{"0201", "0101", "0102", "1212", "2002"};
    String target = "0202";
    System.out.println(openLock(dead, target));
  }
}