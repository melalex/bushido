package com.leetcode.dynamic

import com.leetcode.TestSpec
import com.leetcode.LengthOfLIS.lengthOfLIS

class LengthOfLISSpec extends TestSpec {

  "LengthOfLISSpec" when {
    "input [4,10,4,3,8,9]" should {
      "return 3" in {
        lengthOfLIS(Array(4, 10, 4, 3, 8, 9)) should be(3)
      }
    }

    "input [10,9,2,5,3,7,101,18]" should {
      "return 4" in {
        lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18)) should be(4)
      }
    }

    "input [10,9,2,5,3,4]" should {
      "return 3" in {
        lengthOfLIS(Array(10,9,2,5,3,4)) should be(3)
      }
    }

    "input [2,2]" should {
      "return 1" in {
        lengthOfLIS(Array(2, 2)) should be(1)
      }
    }
  }
}
