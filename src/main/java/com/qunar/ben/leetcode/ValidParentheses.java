package com.qunar.ben.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/7.
 */

public class ValidParentheses {

  private static final Logger logger = LoggerFactory.getLogger(ValidParentheses.class);

  public static boolean isValid(String s) {
    int length = s.length();
    if (length % 2 != 0) {
      return false;
    }
    Stack<Character> opStack = new Stack<>();
    Map<Character, Character> opMap = new HashMap<>();
    opMap.put(')' , '(');
    opMap.put(']' , '[');
    opMap.put('}' , '{');
    Set<Character> pushSet = new HashSet<>(Arrays.asList('(' , '[' , '{'));
    Set<Character> popSet = new HashSet<>(Arrays.asList(')' , ']' , '}'));
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      if (pushSet.contains(c)) {
        opStack.push(c);
      }
      if (popSet.contains(c)) {
        if (opStack.empty() || !opStack.pop().equals(opMap.get(c))) {
          return false;
        }
      }
    }

    return opStack.empty();
  }

  public static void main(String[] args) {
    System.out.printf(String.valueOf(isValid("()")));
  }

  /**
   * Do not allocate extra space for another array,
   * you must do this by modifying the input array in-place with O(1) extra memory.
   * @param nums
   * @return
   */
  public int removeDuplicates(int[] nums) {

    return 0;
  }
}