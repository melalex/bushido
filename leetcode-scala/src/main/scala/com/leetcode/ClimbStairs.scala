package com.leetcode

object ClimbStairs {

  def climbStairs(n: Int): Int = {
    var fib1 = 0
    var fib2 = 1

    for (i <- 2 to n + 1) {
      fib2 += fib1
      fib1 = fib2 - fib1
    }

    fib2
  }
}
