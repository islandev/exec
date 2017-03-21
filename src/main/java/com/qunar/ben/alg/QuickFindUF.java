package com.qunar.ben.alg;

/**
 * Created by ben on 2017/3/21.
 */
public class QuickFindUF implements  UnionFind {
    private  int[] id;
    public  QuickFindUF(int N){
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
        }
    }

    public  boolean connected(int p,int q){
        return  id[p]==id[q];
    }

    public  void union(int q, int p){
        int pid = id[p];
        int qid= id[q];

        for (int i=0;i<id.length;i++){
            if(id[i]==pid){
                id[i]=qid;
            }
        }
    }
}
