package com.melalex.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

  public int orangesRotting(int[][] grid) {
    var queue = new ArrayDeque<Pos>();
    var m = grid.length;
    var n = grid[0].length;

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          queue.offer(new Pos(i, j, 0));
        }
      }
    }

    var lastRecordedMinute = 0;

    while (!queue.isEmpty()) {
      var it = queue.poll();

      lastRecordedMinute = it.minute;

      rot(it.i + 1, it.j, lastRecordedMinute, grid, queue);
      rot(it.i, it.j + 1, lastRecordedMinute, grid, queue);
      rot(it.i - 1, it.j, lastRecordedMinute, grid, queue);
      rot(it.i, it.j - 1, lastRecordedMinute, grid, queue);
    }

    for (int[] row : grid) {
      for (int col : row) {
        if (col == 1) {
          return -1;
        }
      }
    }

    return lastRecordedMinute;
  }

  private void rot(int i, int j, int lastMinute, int[][] grid, Queue<Pos> queue) {
    if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
      grid[i][j] = 2;
      queue.offer(new Pos(i, j, lastMinute + 1));
    }
  }

  private record Pos(int i, int j, int minute) {

  }

  public static void main(String[] args) {
    var app = new RottingOranges();

    System.out.println(app.orangesRotting(new int[][]{
        new int[]{2, 1, 1},
        new int[]{0, 1, 1},
        new int[]{0, 1, 1}
    }));
  }
}
