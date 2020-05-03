package com.leetcode.dynamic

object CoinChange {

  def coinChange(coins: Array[Int], amount: Int): Int = {
    val queue = collection.mutable.PriorityQueue[(List[Int], Int, Int)]((coins.toList, amount, 0))(Ordering.by[(List[Int], Int, Int), Int](_._3).reverse)

    while (queue.nonEmpty) {
      val (currCoins, currAmount, acc) = queue.dequeue()

      if (currAmount == 0) {
        return acc
      }

      if (currCoins.nonEmpty && currAmount > 0) {
        queue.addOne((currCoins, currAmount - currCoins.head, acc + 1))
        queue.addOne((currCoins.tail, currAmount, acc))
      }
    }

    -1
  }
}
