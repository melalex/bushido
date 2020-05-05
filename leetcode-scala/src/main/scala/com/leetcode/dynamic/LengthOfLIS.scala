package com.leetcode.dynamic

object LengthOfLIS {

  def lengthOfLIS(nums: Array[Int]): Int = {
    var max = 0

    var i = 0
    while (i < nums.length) {
      var j = i + 1
      var currMax = 1
      var prev = nums(i)

      while (j < nums.length) {
        if (nums(j) > prev) {
          currMax += 1
        }

        prev = nums(j)
        j += 1
      }

      max = Math.max(currMax, max)

      i += 1
    }

    max
  }
}
