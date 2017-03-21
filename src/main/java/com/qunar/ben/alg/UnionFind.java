package com.qunar.ben.alg;

/**
 * Created by ben on 2017/3/21.
 */
public interface UnionFind {
    void  union(int p,int q);
    boolean connected(int p,int q);
    int find(int p);
    int count();
}
