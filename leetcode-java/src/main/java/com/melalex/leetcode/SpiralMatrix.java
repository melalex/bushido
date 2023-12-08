package com.melalex.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

  public List<Integer> spiralOrder(int[][] matrix) {
    var m = matrix.length;
    var n = matrix[0].length;
    var expectedLen = m * n;
    var it = 0;
    var result = new ArrayList<Integer>();

    while (result.size() < expectedLen) {
      var i = it;
      var j = it;

      if (expectedLen - result.size() == 1) {
        result.add(matrix[i][j]);
      }

      while (j < n - it - 1 && result.size() < expectedLen) {
        result.add(matrix[i][j]);
        j++;
      }

      while (i < m - it - 1 && result.size() < expectedLen) {
        result.add(matrix[i][j]);
        i++;
      }

      while (j > it && result.size() < expectedLen) {
        result.add(matrix[i][j]);
        j--;
      }

      while (i > it && result.size() < expectedLen) {
        result.add(matrix[i][j]);
        i--;
      }

      it++;
    }

    return result;
  }

//  public List<Integer> spiralOrder(int[][] matrix) {
//    var m = matrix.length;
//    var n = matrix[0].length;
//    var expectedLen = m * n;
//    var i = 0;
//    var result = new ArrayList<Integer>();
//
//    while (result.size() < expectedLen) {
//      for (var j = i; j < n - i; j++) {
//        result.add(matrix[i][j]);
//      }
//
//      for (var j = i + 1; j < m - i; j++) {
//        result.add(matrix[j][n - i - 1]);
//      }
//
//      for (var j = n - i - 2; j > i; j--) {
//        result.add(matrix[m - i - 1][j]);
//      }
//
//      for (var j = m - i - 1; j > i; j--) {
//        result.add(matrix[j][i]);
//      }
//
//      i++;
//    }
//
//    return result;
//  }

  public static void main(String[] args) {
    var app = new SpiralMatrix();

    System.out.println(app.spiralOrder(new int[][]{new int[]{6, 9, 7}}));
  }
}
