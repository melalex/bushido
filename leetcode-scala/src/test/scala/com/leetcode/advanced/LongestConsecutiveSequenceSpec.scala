package com.leetcode.advanced

import com.leetcode.TestSpec
import com.leetcode.LongestConsecutiveSequence.longestConsecutive

class LongestConsecutiveSequenceSpec extends TestSpec {

  "LongestConsecutiveSequence" when {
    "input 100, 4, 200, 1, 3, 2" should {
      "return 4" in {
        longestConsecutive(Array(100, 4, 200, 1, 3, 2)) should be(4)
      }
    }
  }
}
