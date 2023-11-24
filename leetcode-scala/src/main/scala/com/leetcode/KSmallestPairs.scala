package com.leetcode

object KSmallestPairs {

  def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {
    var result = List[List[Int]]()
    var i = 0
    var j = 0
    var counter = 0
    var canMove = true

    while (canMove && counter < k) {
      result = List(nums1(i), nums2(j)) :: result

      if (nums1(i) + nums2(j + 1) > nums1(i + 1) + nums2(0) || j + 1 >= nums2.length) {
        i += 1
      }

      if (i + 1 < nums1.length && j + 1 < nums2.length && nums1(i) + nums2(j + 1) > nums1(i + 1) + nums2(j)) i += 1
      else if (j + 1 < nums2.length) j += 1
      else if (i + 1 < nums1.length) i += 1
      else canMove = false

      counter += 1
    }

    result
  }

  def main(args: Array[String]): Unit = {
    println("output: " + kSmallestPairs(Array(1, 2), Array(3), 3))
  }
}
