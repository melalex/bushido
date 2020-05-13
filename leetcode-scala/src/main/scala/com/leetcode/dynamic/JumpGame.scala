package com.leetcode.dynamic

object JumpGame {

  def canJump(nums: Array[Int]): Boolean = {
    val visited = new Array[Boolean](nums.length)

    visited(nums.length - 1) = true

    for (i <- (nums.length - 1) to 0 by -1) {
      var j = Math.min(i + nums(i), nums.length - 1)

      while (!visited(i) && j >= i) {
        if (visited(j)) {
          visited(i) = true
        }

        j -= 1
      }
    }

    visited.head
  }
}
