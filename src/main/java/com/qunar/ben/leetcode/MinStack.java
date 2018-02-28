package com.qunar.ben.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben.wang on 2018/2/28.
 */

public class MinStack {

  /**
   * initialize your data structure here.
   */

  private int min;
  private List<Integer> stack;

  public MinStack() {
    stack = new ArrayList<>();
  }

  public void push(int x) {
    stack.add(x);
    if (x < min || stack.size() == 1) {
      min = x;
    }
  }

  public void pop() {
    int size = stack.size();
    Integer el = stack.get(size - 1);
    stack.remove(size - 1);
    if (el == min) {
      min = setMin();
    }

  }

  private int setMin() {
    Integer min = Integer.MAX_VALUE;
    for (Integer val : stack) {
      if (val < min) {
        min = val;
      }
    }
    return min;
  }

  public int top() {
    return stack.get(stack.size() - 1);
  }

  public int getMin() {
    return min;
  }
}