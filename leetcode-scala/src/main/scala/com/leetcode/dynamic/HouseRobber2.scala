package com.leetcode.dynamic

object HouseRobber2 {

  def rob(nums: Array[Int]): Int = {
    var currentMax = 0
    var prevMax = 0

    for (i <- nums.indices) {
      val currentHouse = nums(i)
      val newMax = Math.max(currentMax, prevMax + currentHouse)

      prevMax = currentMax
      currentMax = newMax
    }

    currentMax
  }
}
