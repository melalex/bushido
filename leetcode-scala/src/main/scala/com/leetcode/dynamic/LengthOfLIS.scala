package com.leetcode.dynamic

object LengthOfLIS {

  def lengthOfLIS(nums: Array[Int]): Int = {
    val n = nums.length
    val cache = new Array[Int](n)

    def cacheRes(i: Int, value: Int): Int = {
      cache(i) = value

      value
    }

    def iter(prev: Int, i: Int): Int =
      if (i >= n) 0
      else if (prev >= nums(i)) iter(prev, i + 1)
      else if (cache(i) != 0) Math.max(cache(i), iter(prev, i + 1))
      else Math.max(iter(nums(i), i + 1), iter(prev, i + 1)) + 1

    var max = 0

    for (i <- (0 until n).reverse) {
      max = Math.max(cacheRes(i, iter(nums(i), i + 1) + 1), max)
    }

    max
  }
}
