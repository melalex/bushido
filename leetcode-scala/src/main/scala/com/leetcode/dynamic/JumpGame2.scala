package com.leetcode.dynamic

object JumpGame2 {

  def jump(nums: Array[Int]): Int = {
    var next = 0
    var acc = 0
    var curr = -1
    var i = 0

    while (next < nums.length - 1) {
      if (i > curr) {
        acc += 1
        curr = next
      }
      next = Math.max(next, i + nums(i))
      i += 1
    }

    acc
  }

  def main(args: Array[String]): Unit = {
    println(jump(Array(2, 3, 0, 1, 4)))
  }
}
