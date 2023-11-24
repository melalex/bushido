package com.melalex.leetcode;

public class MaximumDistanceBetweenPairs {

  public int maxDistance(int[] nums1, int[] nums2) {
    int max = 0;
    int i = 0;
    int j = 0;

    while (j < nums2.length) {
      if (nums1[i] > nums2[j] && i < nums1.length - 1) {
        i++;
      }
      if (i <= j && nums1[i] <= nums2[j]) {
        max = Math.max(max, j - i);
      }
      j++;
    }

    return max;
  }
}
