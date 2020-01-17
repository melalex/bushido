package com.leetcode.sequences

object MaxProfit {

  def maxProfit(prices: Array[Int]): Int = {

  }

  private val minIndex = findIndex(_ < _)
  private val maxIndex = findIndex(_ > _)

  private def findIndex(op: (Int, Int) => Boolean)(arr: Array[Int], range: Range): Int = {
    var curr = 0

    for {
      i <- range
      if op(arr(i), arr(curr))
    } {
      curr = i
    }

    curr
  }
}
