package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.sequences.TwoSum._

class TwoSumSpec extends TestSpec {

  "TwoSum" when {
    "nums = [2, 7, 11, 15], target = 9" should {
      "return [0, 1]" in {
        twoSum(Array(2, 7, 11, 15), 9) should equal(Array(0, 1))
      }
    }

    "nums = [2, 4, 11, 4, 16], target = 8" should {
      "return [1, 3]" in {
        twoSum(Array(2, 4, 11, 4, 16), 8) should equal(Array(1, 3))
      }
    }

    "nums = [2, 4, 11, 0, 8], target = 8" should {
      "return [3, 4]" in {
        twoSum(Array(2, 4, 11, 0, 8), 8) should equal(Array(3, 4))
      }
    }
  }
}
