package com.leetcode

object ContainsDuplicate {

  /**
   * Given an array of integers, find if the array contains any duplicates.
   *
   * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
   *
   * @param nums given an array of integers
   * @return return true if any value appears at least twice in the array, and it returns false if every element is distinct
   */
  def containsDuplicate(nums: Array[Int]): Boolean = nums.toSet.size != nums.length
}
