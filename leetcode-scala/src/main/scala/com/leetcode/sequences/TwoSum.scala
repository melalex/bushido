package com.leetcode.sequences

object TwoSum {

  /**
   * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
   *
   * You may assume that each input would have exactly one solution, and you may not use the same element twice.
   *
   * Example:
   *
   * Given nums = [2, 7, 11, 15], target = 9,
   *
   * Because nums[0] + nums[1] = 2 + 7 = 9,
   * return [0, 1].
   *
   * @param nums   given an array of integers
   * @param target target sum
   * @return indices of the two numbers such that they add up to a specific target
   */
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val mapping = nums.zipWithIndex
      .map { case (n, i) => target - n -> i }
      .toMap

    nums.to(LazyList)
      .zipWithIndex
      .filter { case (elem, _) => mapping.contains(elem) }
      .map { case (elem, index) => Array(index, mapping(elem)) }
      .filterNot { case Array(left, right) => left == right }
      .head
  }
}
