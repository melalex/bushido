package com.melalex.leetcode;

public class FirstBadVersion {

  public int firstBadVersion(int n) {
    return binarySearchBadVersion(0, n);
  }

  private int binarySearchBadVersion(int from, int to) {
    var middle = from + (to - from) / 2;

    if (isBadVersion(middle) && (middle == 0 || !isBadVersion(middle - 1))) return middle;
    else if (isBadVersion(middle)) return binarySearchBadVersion(from, middle - 1);
    else return binarySearchBadVersion(middle + 1, to);
  }


  private boolean isBadVersion(int version) {
    return false;
  }
}
