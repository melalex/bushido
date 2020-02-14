package com.leetcode.sequences

object SearchInRotatedSortedArray {

  def search(nums: Array[Int], target: Int): Int = {
    def findPivot(low: Int, high: Int): Int = -1

    @scala.annotation.tailrec
    def binarySearch(first: Int, last: Int): Int = {
      val guess = (first + last) / 2

      if (guess == target) guess
      else if (first == last) -1
      else if (guess < target) binarySearch(first, target)
      else binarySearch(target, last)
    }

    val last = nums.length - 1
    val pivot = findPivot(0, last)

    if (pivot == -1) binarySearch(0, last)
    else if (nums(pivot) == target) pivot
    else {
      val guess = binarySearch(0, pivot)

      if (guess != -1) guess
      else binarySearch(pivot, last)
    }
  }
}
