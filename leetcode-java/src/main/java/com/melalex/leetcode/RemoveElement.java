package com.melalex.leetcode;

public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    var k = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        k++;
      } else if (k != 0) {
        nums[i - k] = nums[i];
      }
    }

    return nums.length - k;
  }
}
