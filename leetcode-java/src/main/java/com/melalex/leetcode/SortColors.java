package com.melalex.leetcode;

import java.util.Arrays;

public class SortColors {

  public void sortColors(int[] nums) {
    var left = 0;
    var i = 0;
    var right = nums.length - 1;

    while (i <= right) {
      if (nums[i] == 0) {
        swap(nums, i, left);
        left++;
      } else if (nums[i] == 2) {
        swap(nums, i, right);
        right--;
      }

      i++;
    }
  }

  private void swap(int[] nums, int i1, int i2) {
    var buff = nums[i1];

    nums[i1] = nums[i2];
    nums[i2] = buff;
  }

  public static void main(String[] args) {
    var app = new SortColors();
    var arr = new int[]{2, 0, 2, 1, 1, 0};

    app.sortColors(arr);

    System.out.println(Arrays.toString(arr));
  }
}
