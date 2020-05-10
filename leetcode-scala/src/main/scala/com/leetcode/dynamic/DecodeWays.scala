package com.leetcode.dynamic

object DecodeWays {

  def numDecodings(s: String): Int = {
    def isZero(i: Int): Boolean = s(i) == '0'

    if (isZero(0)) {
      return 0
    }

    val dp = new Array[Int](s.length + 1)

    dp(0) = 1
    dp(1) = 1

    for (i <- 1 until s.length) {
      if (isZero(i) && (isZero(i - 1) || s(i - 1) > '2')) {
        return 0
      }

      if (isZero(i - 1)) {
        dp(i + 1) = dp(i)
      } else if (s(i - 1) == '1') {
        if (isZero(i)) dp(i + 1) = dp(i - 1)
        else dp(i + 1) = dp(i - 1) + dp(i)
      } else if (s(i - 1) == '2') {
        if (isZero(i)) dp(i + 1) = dp(i - 1)
        else if (s(i) <= '6') dp(i + 1) = dp(i) + dp(i - 1)
        else dp(i + 1) = dp(i)
      } else {
        dp(i + 1) = dp(i)
      }
    }

    dp.last
  }
}
