package com.melalex.leetcode;

import java.util.Queue;

public class FloodFill {

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    var target = image[sr][sc];
    var m = image.length;
    var n = image[0].length;
    Queue<Pos> queue = new java.util.ArrayDeque<>();

    if (target != color) {
      queue.offer(new Pos(sr, sc));
    }

    while (!queue.isEmpty()) {
      var it = queue.poll();
      var i = it.i;
      var j = it.j;

      if (i >= 0 && i < m && j >= 0 && j < n && image[i][j] == target) {
        image[i][j] = color;

        queue.offer(new Pos(i + 1, j));
        queue.offer(new Pos(i, j + 1));
        queue.offer(new Pos(i - 1, j));
        queue.offer(new Pos(i, j - 1));
      }
    }

    return image;
  }

  private record Pos(int i, int j) {
  }
}
