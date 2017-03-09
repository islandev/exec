package com.qunar.ben.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/2/23.
 */
public class SumRootLeafNumbers {
    List<Integer>  nums = new ArrayList<>();
    public static int sumNumbers(TreeNode root) {

        if(root==null) return  0;

        return  sumLeaf(root,0,0);
    }

    public  static  int sumLeaf(TreeNode node,int sum ,int num){
        if (node == null) return sum;
        num = num * 10 + node.val;
        if(node.left == null && node.right == null) { sum += num; return sum; }
        sum=  sumLeaf(node.left,sum,num)+ sumLeaf(node.right,sum,num);
        return sum;
    }
    public void  findChild(TreeNode  node){
        if(node ==null)  return;
        if(node.left==null || node.right ==null)  nums.add(node.val);
        if(node.left != null ) {
            node.left.val = node.val*10+node.left.val;
            findChild(node.left);
        }
        if(node.right!=null) {
            node.right.val = node.val*10+node.right.val;
            findChild(node.left);
        }
    }

    public static void main(String[] args) {
        int []  tree = {1,0};
        List<TreeNode>  trs = new ArrayList<>();
        int l = tree.length;
        for (int i=0;i<l;i++){
            TreeNode tr = new TreeNode(tree[i]);
            trs.add(tr);
        }

        for (int i=0; i<l;i++){
            if(l>2*i+1)  trs.get(i).left =  trs.get(2*i+1);
            if(l>2*i+2)  trs.get(i).right = trs.get(2*i+2);
        }
        System.out.println(sumNumbers(trs.get(0)));

    }
}



