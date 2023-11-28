package com.melalex.leetcode;

public class ProductOfArrayExceptSelf {

  public int[] productExceptSelf(int[] nums) {
    var result = new int[nums.length];

    var buff = 1;

    for (var i = 0; i < nums.length; i++) {
      result[i] = buff;
      buff *= nums[i];
    }

    buff = 1;

    for (var i = nums.length - 1; i >= 0; i--) {
      result[i] *= buff;
      buff *= nums[i];
    }

    return result;
  }
}
