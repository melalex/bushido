package com.leetcode.dynamic

import com.leetcode.TestSpec
import com.leetcode.CombinationSum.combinationSum4

class CombinationSumSpec extends TestSpec {

  "CombinationSum" when {
    "nums = [1, 2, 3] target = 4" should {
      "return 7" in {
        combinationSum4(Array(1, 2, 3), 4) should be(7)
      }
    }
  }
}
