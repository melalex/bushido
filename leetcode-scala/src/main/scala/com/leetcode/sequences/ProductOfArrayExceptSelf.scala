package com.leetcode.sequences

object ProductOfArrayExceptSelf {

  def productExceptSelf(nums: Array[Int]): Array[Int] = {
    val length = nums.length
    val result = Array.ofDim[Int](length)
    var leftProduct = 1

    result(length - 1) = nums.last

    for (i <- (length - 2) until 0 by -1) {
      result(i) = nums(i) * result(i + 1)
    }

    for (i <- 0 until length - 1) {
      result(i) = leftProduct * result(i + 1)
      leftProduct *= nums(i)
    }

    result(length - 1) = leftProduct

    result
  }
}
