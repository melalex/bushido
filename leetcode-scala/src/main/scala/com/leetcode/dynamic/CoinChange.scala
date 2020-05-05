package com.leetcode.dynamic

object CoinChange {

  def coinChange(coins: Array[Int], amount: Int): Int = {

    val cache = collection.mutable.Map[Int, Integer]()

    def min(a: Integer, b: Integer): Integer =
      if (a != null && b != null && a >= 0 && b >= 0) Math.min(a, b)
      else if (a != null && a >= 0) a
      else if (b != null && b >= 0) b
      else null

    def first(a: Integer, b: Integer): Integer =
      if (a == null) b else a

    def inc(a: Integer): Integer = if (a == null) null else a + 1

    def inner(amount: Int): Integer =
      if (amount == 0) 0
      else if (amount < 0) null
      else if (cache.contains(amount - 1)) cache(amount - 1)
      else {
        var res: Integer = null

        for (coin <- coins) {
          res = min(inc(inner(amount - coin)), res)
        }

        cache(amount - 1) = res
        cache(amount - 1)
      }

    first(inner(amount), -1)
  }
}
