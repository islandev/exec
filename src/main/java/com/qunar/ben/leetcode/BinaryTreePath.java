package com.qunar.ben.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben.wang on 2018/3/7.
 */

public class BinaryTreePath {

  private List<String> resList = new ArrayList<>();

  public List<String> binaryTreePaths(TreeNode root) {
    if (root == null) {
      return resList;
    }
    binaryPath("", root);
    return resList;
  }


  private void binaryPath(String pre, TreeNode node) {
    if (pre.length() == 0) {
      pre += node.val;
    } else {
      pre += ("->" + node.val);
    }

    if (node.left == null && node.right == null) {
      resList.add(pre);
    }
    if (node.left != null) {
      binaryPath(pre, node.left);
    }
    if (node.right != null) {
      binaryPath(pre, node.right);
    }

  }
}

