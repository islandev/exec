package com.qunar.ben.leetcode;

import scala.math.Ordering;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by ben on 2017/2/22.
 */
public class RandomizedSet {
    HashMap<Integer, Integer> map1;
    HashMap<Integer, Integer> map2;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map1 =  new HashMap<>();
        map2 =  new HashMap<>();
        random = new Random(System.currentTimeMillis());
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map1.containsKey(val))  return  false;
            map1.put(val,map1.size());
            map2.put(map2.size(),val);
            return  true;


    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map1.containsKey(val)) return false;
        int index = map1.get(val);
        map1.remove(val);
        map2.remove(index);
        if(map1.size() ==0) return true;
        if(index == map1.size()) return  true;
        int key  = map2.get(map2.size());
        map1.put(key,index);
        map2.remove(map2.size());
        map2.put(index,key);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(map1.size() ==0) return  -1;
        if(map1.size() ==1 ) return  map2.get(0);

        return  map2.get(random.nextInt(map2.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
