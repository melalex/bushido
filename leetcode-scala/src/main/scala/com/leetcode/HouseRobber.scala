package com.leetcode

object HouseRobber {

  def rob(nums: Array[Int]): Int = {
    if (nums.length == 1) {
      return nums(0)
    }

    def rob(from: Int, until: Int): Int = {
      var currentMax = 0
      var prevMax = 0

      for (i <- from until until) {
        val newMax = Math.max(currentMax, prevMax + nums(i))

        prevMax = currentMax
        currentMax = newMax
      }

      currentMax
    }

    val n = nums.length

    Math.max(rob(0, n - 1), rob(1, n))
  }
}
