package com.qunar.ben.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ben.wang on 2018/3/8.
 */

public class StrImpl {

  private static final Logger logger = LoggerFactory.getLogger(StrImpl.class);

  public int strStr(String haystack, String needle) {
    int sLength = haystack.length();
    int dLength = needle.length();
    if (sLength < dLength) {
      return -1;
    }
    for(int i=0;i<sLength;i++){
    }
    return 0;
  }
}