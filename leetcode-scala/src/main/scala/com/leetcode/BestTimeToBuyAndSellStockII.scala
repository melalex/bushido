package com.leetcode

import scala.collection.mutable

object BestTimeToBuyAndSellStockII {

  def maxProfit(prices: Array[Int]): Int = {
    val dp = new scala.collection.mutable.HashMap[Int, Int]()

    def bestProfit(it: Int, min: Int): Int = {
      if (it >= prices.length) 0
      else if (prices(it) <= min) bestProfit(it + 1, prices(it))
      else math.max(
        bestProfit(it + 1, min),
        prices(it) - min + dp.getOrElseUpdate(it + 1, bestProfit(it + 1, Int.MaxValue))
      )
    }

    bestProfit(0, Int.MaxValue)
  }
}
