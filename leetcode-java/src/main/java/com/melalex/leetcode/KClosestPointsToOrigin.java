package com.melalex.leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class KClosestPointsToOrigin {

  public int[][] kClosest(int[][] points, int k) {
    var map = new TreeMap<Integer, List<int[]>>();

    for (int[] point : points) {
      var order = point[0] * point[0] + point[1] * point[1];

      map.compute(order, (integer, value) -> {
        if (value == null) {
          var newValue = new LinkedList<int[]>();

          newValue.add(point);

          return newValue;
        } else {
          value.add(point);

          return value;
        }
      });
    }

    return map.values()
        .stream()
        .flatMap(Collection::stream)
        .limit(k)
        .toArray(value -> new int[value][2]);
  }

  public static void main(String[] args) {
    var app = new KClosestPointsToOrigin();

    System.out.println(Arrays.deepToString(app.kClosest(new int[][]{new int[]{0, 1}, new int[]{1, 0}}, 2)));
  }
}
