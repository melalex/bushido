package com.melalex.leetcode;

public class MaxIncreaseToKeepCitySkyline {

  public int maxIncreaseKeepingSkyline(int[][] grid) {
    if (grid.length == 0) {
      return 0;
    }

    int[] rowMax = new int[grid.length];
    int[] colMax = new int[grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        rowMax[i] = Math.max(rowMax[i], grid[i][j]);
        colMax[j] = Math.max(colMax[j], grid[i][j]);
      }
    }

    int result = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        result += Math.min(rowMax[i], colMax[j]) - grid[i][j];
      }
    }

    return result;
  }
}
