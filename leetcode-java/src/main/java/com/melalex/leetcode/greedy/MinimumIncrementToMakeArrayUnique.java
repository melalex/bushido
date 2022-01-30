package com.melalex.leetcode.greedy;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

  public int minIncrementForUnique(int[] nums) {
    Arrays.sort(nums);

    System.out.println(Arrays.toString(nums));

    if (nums.length < 2) {
      return 0;
    }

    var lastNum = nums[0];
    var result = 0;

    for (var i = 1; i < nums.length; i++) {
      if (lastNum >= nums[i]) {
        result += lastNum - nums[i] + 1;
        nums[i] = lastNum + 1;
      }

      lastNum = nums[i];
    }

    return result;
  }

//  public int minIncrementForUnique(int[] nums) {
//    Arrays.sort(nums);
//
//    System.out.println(Arrays.toString(nums));
//
//    if (nums.length < 2) {
//      return 0;
//    }
//
//    var currentCombo = 0;
//    var lastNum = nums[0];
//    var result = 0;
//    var lowerLine = 0;
//
//    for (var i = 1; i < nums.length; i++) {
//      var currentNum = nums[i];
//
//      currentCombo++;
//
//      System.out.println("Current: " + currentNum);
//      System.out.println("Last: " + lastNum);
//      System.out.println("Result: " + result);
//      System.out.println("Combo: " + currentCombo);
//      System.out.println("Lower line: " + lowerLine);
//      System.out.println();
//
//      if (currentNum <= lowerLine) {
//        result += lowerLine;
//      }
//
//      if (currentNum != lastNum || i == nums.length - 1) {
//        result += currentCombo * (currentCombo - 1) / 2;
//        lowerLine += lastNum + currentCombo - 1;
//        currentCombo = 0;
//      }
//
//      lastNum = currentNum;
//    }
//
//    return result;
//  }

//  private int iter(int[] nums, int num, int i, Set<Integer> occupied, int result) {
//    System.out.println("iter(" + Arrays.toString(nums) + ", " + num + ", " + i + ", " + ", " + occupied + ", " + result + ")");
//    if (occupied.contains(num)) return iter(nums, num + 1, i, occupied, result + 1);
//    else if (i + 1 >= nums.length) return result;
//    else {
//      occupied.add(num);
//
//      return iter(nums, nums[i + 1], i + 1, occupied, result);
//    }
//  }
//
//  public int minIncrementForUnique(int[] nums) {
//    if (nums.length == 0) return 0;
//    return iter(nums, nums[0], 0, new HashSet<>(), 0);
//  }

  public static void main(String[] args) {
    var res = new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7});

    System.out.println(res);
  }
}
