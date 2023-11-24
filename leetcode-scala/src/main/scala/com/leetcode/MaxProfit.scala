package com.leetcode

object MaxProfit {

  def maxProfit(prices: Array[Int]): Int = {
    var maxProfit = 0
    var min = Int.MaxValue

    for (elem <- prices) {
      if (elem < min) {
        min = elem
      } else {
        val profit = elem - min
        if (profit > maxProfit) {
          maxProfit = profit
        }
      }
    }

    maxProfit
  }
}
