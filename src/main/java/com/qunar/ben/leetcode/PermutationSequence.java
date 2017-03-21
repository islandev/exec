package com.qunar.ben.leetcode;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){

        }
        return  "";
    }

    public  int getVal(int n, int k, List<Integer> arr){
        int index = k/fab(n-1);
        int res = arr.get(index);
        arr.remove(index);
        return 0;
    }

    public  int fab(int val){
        if(val<0){
            throw  new IllegalArgumentException();
        }
        int res =1;
        for(int i=2;i<=val;i++){
            res *=i;
        }
        return  res;

    }
}
