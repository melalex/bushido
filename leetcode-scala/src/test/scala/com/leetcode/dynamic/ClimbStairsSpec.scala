package com.leetcode.dynamic

import com.leetcode.TestSpec
import com.leetcode.dynamic.ClimbStairs.climbStairs

class ClimbStairsSpec extends TestSpec {

  "ClimbStairs" when {
    "input 1" should {
      "return 1" in {
        climbStairs(1) should be(1)
      }
    }

    "input 2" should {
      "return 2" in {
        climbStairs(2) should be(2)
      }
    }

    "input 3" should {
      "return 3" in {
        climbStairs(3) should be(3)
      }
    }

    "input 35" should {
      "return 14930352" in {
        climbStairs(35) should be(14930352)
      }
    }

    "input 45" should {
      "return 45" in {
        climbStairs(45) should be(1836311903)
      }
    }
  }
}
