package com.leetcode

object LengthOfLIS {

  def lengthOfLIS(nums: Array[Int]): Int = {
    if (nums.isEmpty) {
      return 0
    }

    val n = nums.length
    val cache = new Array[Int](n)
    var max = 0
    var i = 0

    cache(0) = 1

    while (i < nums.length) {
      var j = 0
      val iVal = nums(i)
      var currentMax = 0

      while (j < i) {
        if (nums(j) < iVal) {
          currentMax = Math.max(currentMax, cache(j))
        }

        j += 1
      }

      cache(i) = currentMax + 1
      max = Math.max(cache(i), max)

      i += 1
    }

    max
  }
}
