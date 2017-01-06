package com.qunar.ben.leetcode;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ben on 2017/1/6.
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class LAFP {
    public int lengthLongestPath(String input) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(String s :input.split("\n")){
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                res = Math.max(res, map.get(level) + len);
            } else {
                map.put(level + 1, map.get(level) + len + 1);
            }
        }
        return res;
    }

}