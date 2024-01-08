package com.melalex.leetcode;

import java.util.Arrays;

public class HIndex {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);

    if (citations[0] > citations.length) {
      return citations.length;
    }

    for (var i = 1; i < citations.length; i++) {
      if (citations[i] > citations.length - i) {
        return citations[i - 1];
      }
    }

    return citations[citations.length - 1];
  }
}
