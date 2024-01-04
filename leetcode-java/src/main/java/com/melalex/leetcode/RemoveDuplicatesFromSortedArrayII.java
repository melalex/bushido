package com.melalex.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArrayII {

  public int removeDuplicates(int[] nums) {
    var k = 0;

    for (var i = 2; i < nums.length; i++) {
      if (nums[i] == nums[i - k - 1] && nums[i] == nums[i - k - 2]) {
        k++;
      } else if (k != 0) {
        nums[i - k] = nums[i];
      }
    }

    return nums.length - k;
  }

  public static void main(String[] args) {
    var app = new RemoveDuplicatesFromSortedArrayII();
    var arr = new int[]{1, 1, 1, 2, 2, 3};
    var take = app.removeDuplicates(arr);

    System.out.println(Arrays.stream(arr).limit(take).boxed().collect(Collectors.toList()));
  }
}
