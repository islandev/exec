package com.qunar.ben.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ben.wang on 2018/2/2.
 */

public class MergeKList {

  public ListNode megerKList(ListNode[] listNodes) {
    ListNode dummy = new ListNode(0);

    return dummy.next;
  }

  public boolean judgeCircle(String moves) {
    int x = 0;
    int y = 0;

    for (Character c : moves.toCharArray()) {
      switch (c) {
        case 'U':
          y++;
          break;
        case 'D':
          y--;
          break;
        case 'L':
          x--;
          break;
        case 'R':
          x++;
          break;
      }
    }

    return x == 0 && y == 0;
  }

  public static List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> targets = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (reachLine(matrix, m, n, i, j, 0) && reachLine(matrix, m, n, i, j, 1)) {
          targets.add(new int[]{i, j});
        }
      }
    }

    return targets;
  }

  private static boolean checkHeight(int[][] matrix, int m, int n, int i, int j) {

    int up = i - 1;
    int down = i + 1;
    int left = j - 1;
    int right = j + 1;

    up = up < 0 ? 0 : up;
    down = down >= m ? m - 1 : down;
    left = left < 0 ? 0 : left;
    right = right >= n ? n - 1 : right;

    return matrix[i][j] >= matrix[up][j] && matrix[i][j] >= matrix[down][j]
        && matrix[i][j] >= matrix[i][left] && matrix[i][j] >= matrix[i][right];
  }


  private static boolean reachLine(int[][] matrix, int m, int n, int i, int j, int dimension) {
    Queue<int[]> targetQueue = new LinkedList<>();
    targetQueue.offer(new int[]{i, j});
    while (!targetQueue.isEmpty()) {
      int[] poll = targetQueue.poll();
      if (getLine(poll, m, n, dimension)) {
        return true;
      }
      Set<int[]> nextLine = getNextLine(matrix, m, n, poll);
      for (int[] item : nextLine) {
        targetQueue.offer(item);
      }
    }
    return false;
  }

  private static boolean getLine(int[] position, int m, int n, int dimension) {
    if (dimension == 0) {
      return position[0] == 0 || position[1] == 0;
    }
    if (dimension == 1) {
      return position[0] == m || position[1] == n;
    }
    return false;
  }

  private static Set<int[]> getNextLine(int[][] matrix, int m, int n, int[] poll) {
    int i = poll[0];
    int j = poll[1];
    Set<int[]> targetSets = new HashSet<>();
    int up = i - 1;
    int down = i + 1;
    int left = j - 1;
    int right = j + 1;

    up = up < 0 ? 0 : up;
    down = down >= m ? m - 1 : down;
    left = left < 0 ? 0 : left;
    right = right >= n ? n - 1 : right;

    addIfSatisfy(targetSets, matrix, i, j, up, j);
    addIfSatisfy(targetSets, matrix, i, j, down, j);
    addIfSatisfy(targetSets, matrix, i, j, i, left);
    addIfSatisfy(targetSets, matrix, i, j, i, right);
    targetSets.remove(poll);
    return targetSets;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5}, {
        5, 1, 1, 2, 4}};
    List<int[]> ints = pacificAtlantic(matrix);

    for (int[] val : ints) {
      for (int item : val) {
        System.out.printf(String.valueOf(item));

      }
      System.out.printf("#####");
    }

  }

  private static void addIfSatisfy(Set<int[]> targetSets, int[][] matrix, int m, int n, int i,
      int j) {
    if (matrix[m][n] >= matrix[i][j]) {
      targetSets.add(new int[]{i, j});
    }
  }
}