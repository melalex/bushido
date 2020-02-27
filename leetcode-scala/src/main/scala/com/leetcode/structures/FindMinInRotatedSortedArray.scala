package com.leetcode.structures

object FindMinInRotatedSortedArray {

  def findMin(nums: Array[Int]): Int = {
    val last = nums(nums.length - 1)

    @inline
    def mid(left: Int, right: Int): Int = left + (right - left) / 2

    @scala.annotation.tailrec
    def findPivot(left: Int, right: Int): Int = {
      val prevVal = if (left == 0) last else nums(left - 1)
      val leftVal = nums(left)
      val rightVal = nums(right)

      if (prevVal < leftVal) leftVal
      else if (leftVal > rightVal) findPivot(mid(left, right), right)
      else findPivot(0, left)
    }

    findPivot(0, nums.length - 1)
  }
}
