package com.leetcode.sequences

object MaxSubArray {

  def maxSubArray(nums: Array[Int]): Int = {
    if (nums.isEmpty) {
      return 0
    }

    var currentSum = nums(0)
    var bestSum = nums(0)

    for (i <- 1 until nums.length) {
      currentSum = Math.max(nums(i), currentSum + nums(i))
      bestSum = Math.max(currentSum, bestSum)
    }

    bestSum
  }
}
