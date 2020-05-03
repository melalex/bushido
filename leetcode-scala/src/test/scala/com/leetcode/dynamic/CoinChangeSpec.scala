package com.leetcode.dynamic

import com.leetcode.TestSpec
import com.leetcode.dynamic.CoinChange.coinChange

class CoinChangeSpec extends TestSpec {

  "CoinChange" when {
    "coins = [1, 2, 5], amount = 11" should {
      "return 3" in {
        coinChange(Array(1, 2, 5), 11) should be(3)
      }
    }

    "coins = [288,160,10,249,40,77,314,429], amount = 9208" should {
      "return 22" in {
        coinChange(Array(288, 160, 10, 249, 40, 77, 314, 429), 9208) should be(22)
      }
    }

    "coins = [88,227,216,96,209,172,259], amount = 6928" should {
      "return 28" in {
        coinChange(Array(88,227,216,96,209,172,259), 6928) should be(28)
      }
    }

    "coins = [1,2], amount = 3" should {
      "return 2" in {
        coinChange(Array(1,2), 3) should be(2)
      }
    }
  }
}
