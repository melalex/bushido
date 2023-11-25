package com.melalex.leetcode;

public class MajorityElement {

  public int majorityElement(int[] nums) {
    var candidate = nums[0];
    var count = 1;

    for (var i = 1; i < nums.length; i++) {
      var current = nums[i];

      if (count == 0) {
        candidate = current;
        count++;
      } else if (candidate == current) {
        count++;
      } else {
        count--;
      }
    }

    return candidate;
  }
}
