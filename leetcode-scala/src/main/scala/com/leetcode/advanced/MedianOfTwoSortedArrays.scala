package com.leetcode.advanced

object MedianOfTwoSortedArrays {

  def findMedianSortedArrays(num1: Array[Int], num2: Array[Int]): Double = {
    val (aNum, bNum) = if (num1.length > num2.length) (num2, num1) else (num1, num2)

    val totalLen = aNum.length + bNum.length
    val isTotalLenEven = totalLen % 2 == 0
    val half = totalLen / 2

    def getVal(arr: Array[Int], i: Int): Int =
      if (i < 0) Int.MinValue
      else if (i >= arr.length) Int.MaxValue
      else arr(i)

    @scala.annotation.tailrec
    def iter(left: Int, right: Int): Double = {
      val aPointer = math.floor((left + right).toDouble / 2).toInt
      val bPointer = half - aPointer - 2

      val aLeft = getVal(aNum, aPointer)
      val aRight = getVal(aNum, aPointer + 1)
      val bLeft = getVal(bNum, bPointer)
      val bRight = getVal(bNum, bPointer + 1)

      if (aLeft > bRight) iter(left, aPointer - 1)
      else if (bLeft > aRight) iter(aPointer + 1, right)
      else if (isTotalLenEven) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)).toDouble / 2
      else Math.min(aRight, bRight).toDouble
    }

    iter(0, aNum.length - 1)
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1, 3), Array(2)))
    println(findMedianSortedArrays(Array(1, 2), Array(3, 4)))
    println(findMedianSortedArrays(Array(3, 4), Array(1, 2)))
    println(findMedianSortedArrays(Array(), Array(1)))
    println(findMedianSortedArrays(Array(), Array(2, 3)))
    println(findMedianSortedArrays(Array(3), Array(-2, -1)))
    println(findMedianSortedArrays(Array(5, 6), Array(1, 2, 3, 4, 7, 8)))
  }
}
