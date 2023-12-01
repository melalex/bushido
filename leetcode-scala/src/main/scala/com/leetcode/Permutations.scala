package com.leetcode

object Permutations {

  def permute(nums: Array[Int]): List[List[Int]] = {
    val result = new scala.collection.mutable.ListBuffer[List[Int]]()

    def loop(curr: List[Int]): Unit = {
      if (curr.length == nums.length) result += curr
      else
        for (i <- nums.indices if !curr.contains(nums(i)))
          loop(curr :+ nums(i))
    }

    loop(Nil)

    result.toList
  }

  def nextPermutation(nums: Array[Int]): Array[Int] = {
    def swap(i1: Int, i2: Int): Unit = {
      val buff = nums(i1)

      nums(i1) = nums(i2)
      nums(i2) = buff
    }

    def reverse(from: Int): Unit = {
      var i = from
      var j = nums.length - 1
      while (i < j) {
        swap(i, j)
        i += 1
        j -= 1
      }
    }

    def findLeftSummit(): Int = {
      for (i <- nums.length - 1 to 1 by -1) {
        if (nums(i - 1) < nums(i)) {
          return i
        }
      }

      0
    }

    val leftSummit = findLeftSummit()

    if (leftSummit != 0) {
      val swapTarget = leftSummit - 1
      var swapCandidate = leftSummit

      for (i <- leftSummit + 1 until nums.length) {
        if (nums(swapTarget) < nums(i) && nums(swapCandidate) >= nums(i)) {
          swapCandidate = i
        }
      }

      swap(swapTarget, swapCandidate)
    }

    reverse(leftSummit)

    nums
  }

  def factorial(n: Int): Int = {
    var f = 1
    for (i <- 1 to n) {
      f = f * i
    }

    f
  }

  def main(args: Array[String]): Unit = {
    println(nextPermutation(Array(2, 3, 1, 3, 3)).mkString("Array(", ", ", ")"))
  }
}
