package com.leetcode

object LongestConsecutiveSequence {

  def longestConsecutive(nums: Array[Int]): Int = {
    val set = collection.mutable.Set(nums: _*)
    var max = 0

    for (num <- nums; if !set(num - 1)) {
      var pointer = num

      while (set(pointer)) {
        pointer += 1
      }

      max = Math.max(pointer - num, max)
    }

    max
  }
}
