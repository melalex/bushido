package com.leetcode.advanced

object MedianOfTwoSortedArrays {

  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    def getValue(nums: Array[Int], i: Int) =
      if (i >= nums.length) Int.MaxValue
      else if (i < 0) Int.MinValue
      else nums(i)

    val (numsA, numsB) =
      if (nums1.length >= nums2.length) (nums1, nums2)
      else (nums2, nums1)

    val totalLength = numsA.length + numsB.length
    val halfLength = totalLength / 2
    var l = 0
    var r = numsA.length - 1

    while (true) {
      val i = (l + r) / 2
      val j = halfLength - i - 2

      val aLeft = getValue(numsA, i)
      val aRight = getValue(numsA, i + 1)
      val bLeft = getValue(numsB, j)
      val bRight = getValue(numsB, j + 1)

      if (aLeft <= bRight && bLeft <= aRight) {
        return if (totalLength % 2 != 0) Math.min(aRight, bRight)
        else (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)).toDouble / 2
      } else if (aLeft > bRight) {
        r = i - 1
      } else {
        l = i + 1
      }
    }

    throw new IllegalArgumentException
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1, 3), Array(2)))
    println(findMedianSortedArrays(Array(1, 2), Array(3, 4)))
    println(findMedianSortedArrays(Array(3, 4), Array(1, 2)))
    println(findMedianSortedArrays(Array(), Array(1)))
    println(findMedianSortedArrays(Array(), Array(2, 3)))
    println(findMedianSortedArrays(Array(3), Array(-2, -1)))
  }
}
