package com.leetcode

object SearchInRotatedSortedArray {

  def search(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) {
      return -1
    }

    val last = nums.length - 1

    @scala.annotation.tailrec
    def findPivot(low: Int, high: Int): Int = {
      val prev = if (low == 0) last else low - 1
      val lowVal = nums(low)
      val highVal = nums(high)

      if (lowVal < nums(prev)) low
      else if (lowVal > highVal) findPivot(mid(high, low), high)
      else findPivot(0, low)
    }

    @scala.annotation.tailrec
    def binarySearch(first: Int, last: Int): Int = {
      val guess = mid(first, last)
      val guessVal = nums(guess)

      if (guessVal == target) guess
      else if (first >= last) -1
      else if (guessVal > target) binarySearch(first, guess - 1)
      else binarySearch(guess + 1, last)
    }

    @inline
    def mid(first: Int, last: Int): Int = {
      first + (last - first) / 2
    }

    val pivot = if (last == 0) 0 else findPivot(0, last)

    if (nums(pivot) == target) pivot
    else {
      val guess = binarySearch(pivot, last)

      if (guess != -1) guess
      else binarySearch(0, pivot - 1)
    }
  }
}
