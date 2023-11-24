package com.leetcode

class BinarySearch {

  def search(nums: Array[Int], target: Int): Int = {
    @scala.annotation.tailrec
    def iter(left: Int, right: Int): Int =
      if (left > right || left >= nums.length) -1
      else {
        val mid = left + (right - left) / 2
        val midValue = nums(mid)

        if (midValue == target) mid
        else if (midValue > target) iter(left, mid - 1)
        else iter(mid + 1, right)
      }

    iter(0, nums.length - 1)
  }
}
