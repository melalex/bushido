package com.melalex.leetcode;

import java.util.Arrays;

public class RotateArray {

  public void rotate(int[] nums, int k) {
    var rotation = k % nums.length;
    var buff = new int[rotation];

    System.arraycopy(nums, nums.length - rotation, buff, 0, rotation);
    System.arraycopy(nums, 0, nums, rotation, nums.length - rotation);
    System.arraycopy(buff, 0, nums, 0, rotation);
  }
}
