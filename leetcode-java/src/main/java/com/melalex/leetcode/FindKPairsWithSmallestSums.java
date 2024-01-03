package com.melalex.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

  public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
    var queue = new PriorityQueue<>(k, Comparator.comparingInt(SmallestPair::sum));
    var result = new ArrayList<List<Integer>>(k);

    for (int runner : a) {
      queue.offer(new SmallestPair(runner + b[0], runner, 0));
    }

    for (int i = 0; i < k && !queue.isEmpty(); i++) {
      var it = queue.poll();

      result.add(List.of(it.aVal, b[it.bIndex]));

      if (it.bIndex + 1 < b.length) {
        queue.offer(new SmallestPair(it.aVal + b[it.bIndex + 1], it.aVal, b[it.bIndex + 1]));
      }
    }

    return result;
  }

  private record SmallestPair(
      int sum,
      int aVal,
      int bIndex
  ) {

  }

  public static void main(String[] args) {
    var app = new FindKPairsWithSmallestSums();

    System.out.println(app.kSmallestPairs(new int[]{1, 2, 4, 5, 6}, new int[]{3, 5, 7, 9}, 3));
  }
}
