package com.melalex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {

  public List<Integer> countSmaller(int[] nums) {
    var len = nums.length;

    if (len == 1) {
      return List.of(0);
    }

    var result = new Integer[len];
    var toSort = new IndexAndVal[len];

    for (int i = 0; i < len; i++) {
      toSort[i] = new IndexAndVal(i, nums[i]);
    }

    Arrays.fill(result, 0);

    mergeSort(toSort, 0, len - 1, result);

    return Arrays.asList(result);
  }

  private void mergeSort(IndexAndVal[] nums, int start, int end, Integer[] result) {
    if (start >= end) return;

    int mid = (start + end) / 2;

    mergeSort(nums, start, mid, result);
    mergeSort(nums, mid + 1, end, result);

    merge(nums, start, mid, end, result);
  }

  private void merge(IndexAndVal[] nums, int start, int mid, int end, Integer[] result) {
    var leftPos = start;
    var rightPos = mid + 1;
    var merged = new ArrayList<IndexAndVal>(end - start);
    var lessThenCounter = 0;

    while (leftPos <= mid && rightPos <= end) {
      if (nums[leftPos].value > nums[rightPos].value) {
        ++lessThenCounter;

        merged.add(nums[rightPos]);
        ++rightPos;
      } else {
        result[nums[leftPos].index] += lessThenCounter;

        merged.add(nums[leftPos]);
        ++leftPos;
      }
    }

    while (leftPos <= mid) {
      result[nums[leftPos].index] += lessThenCounter;

      merged.add(nums[leftPos]);
      ++leftPos;
    }

    while (rightPos <= end) {
      merged.add(nums[rightPos]);
      ++rightPos;
    }

    var pos = start;
    for (var m : merged) {
      nums[pos] = m;
      ++pos;
    }
  }

  private record IndexAndVal(int index, int value) {

  }

  public static void main(String[] args) {
    var app = new CountOfSmallerNumbersAfterSelf();

    System.out.println(app.countSmaller(new int[]{5, 2, 6, 1}));
  }
}
