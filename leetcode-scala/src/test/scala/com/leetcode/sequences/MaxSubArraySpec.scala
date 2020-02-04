package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.sequences.MaxSubArray.maxSubArray

class MaxSubArraySpec extends TestSpec {

  "Maximum Subarray" when {
    "input: [-2,1,-3,4,-1,2,1,-5,4]" should {
      "return 6" in {
        maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)) should be(6)
      }
    }

    "input: -1" should {
      "return -1" in {
        maxSubArray(Array(-1)) should be(-1)
      }
    }
  }
}
