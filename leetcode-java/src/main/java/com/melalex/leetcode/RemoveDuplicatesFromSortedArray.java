package com.melalex.leetcode;

public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    var k = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        k++;
      } else if (k != 0) {
        nums[i - k] = nums[i];
      }
    }

    return nums.length - k;
  }
}
