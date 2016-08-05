package com.qunar.ben.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ben on 16/8/2.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 */
public class TopKFrequetEl {
    public List<Integer> topKFrequent(int[] nums, int k){
        List<Integer> result =  new ArrayList<>();
        HashMap<Integer,Integer> countMap = new HashMap<>();
        for(int val :nums){
            if(countMap.containsKey(val)) countMap.put(val,countMap.get(val)+1);
            else countMap.put(val,1);
        }

        return  result;
    }

    public int[] initMaxHeap(int[] array){
        int  nodeIndex = (array.length-1)>>1;
        for(int i=nodeIndex;i>=0;i--){
            maxHeapify(array,array.length,i);
        }
        return array;
    }

    public  static  void maxHeapify(int[] data, int l, int startIndex){

    }

}
