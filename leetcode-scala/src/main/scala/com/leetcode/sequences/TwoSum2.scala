package com.leetcode.sequences

object TwoSum2 {

  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    var left = 0
    var right = numbers.length - 1

    while (left < right) {
      val leftValue = numbers(left)
      val rightValue = numbers(right)

      if (leftValue + rightValue == target) {
        return Array(left, right)
      } else if (leftValue + rightValue > target) {
        right -= 1
      } else if (leftValue + rightValue < target) {
        left += 1
      }
    }

    throw new IllegalArgumentException()
  }

  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2, 7, 11, 15), 9).mkString("Array(", ", ", ")"))
    println(twoSum(Array(2, 3, 4), 6).mkString("Array(", ", ", ")"))
    println(twoSum(Array(-1, 0), -1).mkString("Array(", ", ", ")"))
  }
}
