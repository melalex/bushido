package com.leetcode.dynamic

object CoinChange {

  def coinChange(coins: Array[Int], amount: Int): Int = {
    if (amount == 0) {
      return 0
    }

    val queue = collection.mutable.PriorityQueue[(List[Int], Int, Int)]((coins.toList, amount, 1))(Ordering.by[(List[Int], Int, Int), Int](_._3).reverse)
    val visited = collection.mutable.Set[(List[Int], Int)]()

    while (queue.nonEmpty) {
      val (currCoins, currAmount, acc) = queue.dequeue()
      val restTails = currCoins.tail

      if (currCoins.size > 1 && !visited((restTails, currAmount))) {
        queue.addOne((restTails, currAmount, acc))
        visited.add((restTails, currAmount))
      }

      val newAmount = currAmount - currCoins.head

      if (newAmount == 0) {
        return acc
      }

      if (newAmount > 0 && !visited((currCoins, newAmount))) {
        queue.addOne((currCoins, newAmount, acc + 1))
        visited.add((currCoins, newAmount))
      }
    }

    -1
  }
}
