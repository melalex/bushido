package com.leetcode

object FindMinInRotatedSortedArray {

  def findMin(nums: Array[Int]): Int = {
    var l = 0
    var r = nums.length - 1

    while (l < r) {
      val m = (l + r) / 2
      if (nums(m) < nums(r)) r = m
      else l = m + 1
    }

    nums(l)
  }

  def main(args: Array[String]): Unit = {
//    println(findMin(Array(3, 4, 5, 1, 2)))
    println(findMin(Array(4, 5, 6, 7, 0, 1, 2)))
    println(findMin(Array(11, 13, 15, 17)))
    println(findMin(Array(5, 1, 2, 3, 4)))
    println(findMin(Array(5, 1, 2, 3, 4)))
  }
}
