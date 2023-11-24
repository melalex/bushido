package com.leetcode

object JumpGame {

  def canJump(nums: Array[Int]): Boolean = {
    var lastPos = nums.length - 1
    for (i <- nums.length - 1 to 0 by -1) {
      if (i + nums(i) >= lastPos) lastPos = i
    }

    lastPos == 0
  }
}
