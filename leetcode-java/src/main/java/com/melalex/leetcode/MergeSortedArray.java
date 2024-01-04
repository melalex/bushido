package com.melalex.leetcode;

import java.util.ArrayDeque;

public class MergeSortedArray {

  public void merge(int[] a, int m, int[] b, int n) {
    var aRunner = m - 1;
    var bRunner = n - 1;

    for (int i = a.length - 1; i >= 0; i--) {
      if (bRunner < 0 || (aRunner > 0 && a[aRunner] > b[bRunner])) {
        a[i] = a[aRunner];
        aRunner--;
      } else {
        a[i] = b[bRunner];
        bRunner--;
      }
    }
  }
}
