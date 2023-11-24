package com.leetcode

object MaximumProductSubarray {

  def maxProduct(nums: Array[Int]): Int = {
    var minValue = 1
    var maxValue = 1
    var globalMaxValue = Int.MinValue

    for (elem <- nums) {
      val localMax = maxValue

      maxValue = max(elem, elem * maxValue, elem * minValue)
      minValue = min(elem, elem * localMax, elem * minValue)

      globalMaxValue = Math.max(globalMaxValue, maxValue)
    }

    globalMaxValue
  }

  @inline
  def max(a: Int, b: Int, c: Int): Int = Math.max(Math.max(a, b), c)

  @inline
  def min(a: Int, b: Int, c: Int): Int = Math.min(Math.min(a, b), c)
}
