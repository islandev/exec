package com.qunar.ben.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 2017/2/23.
 */
public class LCA {
    List<TreeNode>  listNode = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findNode(root,p);
        List<TreeNode> plist = new ArrayList<>();
        plist = listNode;
        listNode.clear();
        findNode(root,q);
        TreeNode tr = new TreeNode(0);
        int i=0;
        while (i<plist.size()){
            for (int j =0;j< listNode.size();j++){
                if(i== plist.size()-1|| j == listNode.size()-1){
                    tr=plist.get(i);
                    break;
                }
                if (plist.get(i+1) != listNode.get(j+1)) {
                    tr = plist.get(i);
                    break;
                }
                i++;
            }
        }

        return  tr;
    }
    public  void findNode(TreeNode cur, TreeNode p){
        if (cur ==null)  return;
        listNode.add(cur);
        if (cur == p)
            return ;
        if(cur !=p) {
            findNode(cur.left, p);
            findNode(cur.right, p);
        }
    }
}
