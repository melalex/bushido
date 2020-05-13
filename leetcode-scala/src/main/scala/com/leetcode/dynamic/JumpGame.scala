package com.leetcode.dynamic

object JumpGame {

  def canJump(nums: Array[Int]): Boolean = {
    val visited = new Array[Boolean](nums.length)

    def iter(i: Int): Boolean =
      if (i == nums.length - 1) true
      else if (i >= nums.length || visited(i) || nums(i) == 0) false
      else {
        visited(i) = true

        for (step <- (i to Math.min(i + nums(i), nums.length - 1)).reverse) {
          if (iter(step)) {
            return true
          }
        }

        false
      }

    iter(0)
  }
}
