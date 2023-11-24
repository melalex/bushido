package com.leetcode.dynamic

import com.leetcode.TestSpec
import com.leetcode.DecodeWays.numDecodings

class DecodeWaysSpec extends TestSpec {

  "DecodeWays" when {
    "input '12'" should {
      "return 2" in {
        numDecodings("12") should be(2)
      }
    }

    "input '226'" should {
      "return 3" in {
        numDecodings("226") should be(3)
      }
    }

    "input '2262'" should {
      "return 3" in {
        numDecodings("2262") should be(3)
      }
    }

    "input '2222'" should {
      "return 5" in {
        numDecodings("2222") should be(5)
      }
    }
  }
}
