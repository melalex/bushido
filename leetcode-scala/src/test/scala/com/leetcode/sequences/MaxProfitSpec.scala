package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.sequences.MaxProfit.maxProfit

class MaxProfitSpec extends TestSpec {

  "Max profit" when {
    "input: [7, 1, 5, 3, 6, 4]" should {
      "return 5" in {
        maxProfit(Array(7, 1, 5, 3, 6, 4)) should be(5)
      }
    }

    "input: [7, 6, 4, 3, 1]" should {
      "return 0" in {
        maxProfit(Array(7, 6, 4, 3, 1)) should be(0)
      }
    }

    "large input" should {
      "return 0" in {
        maxProfit((100_000 to 0 by -1).to(Array)) should be(0)
      }
    }
  }
}
