package com.qunar.ben.leetcode;


import java.util.List;

/**
 * Created by ben.wang on 2018/2/28.
 */

public class ErectFence {


  public List<Point> outerTrees(Point[] points) {
    Point minPoint = getMinPoint(points);

    return null;
  }

  private Point getMinPoint(Point[] points) {
    Point o = new Point();
    Point zero = new Point(0, 0);
    double min = 500;
    for (Point p : points) {
      double distance = getDistance(zero, p);
      if (distance < min) {
        o = p;
        min = distance;
      }
    }
    return o;
  }

  private double getDistance(Point o, Point cur) {
    return Math.sqrt(Math.pow(o.x - cur.x, 2) + Math.pow(o.x - cur.y, 2));
  }
}