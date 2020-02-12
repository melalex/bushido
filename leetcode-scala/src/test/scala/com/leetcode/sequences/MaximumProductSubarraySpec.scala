package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.sequences.MaximumProductSubarray.maxProduct

class MaximumProductSubarraySpec extends TestSpec {

  "MaximumProductSubarraySpec" when {
    "input: [2, 3, -2, 4]" should {
      "return 6" in {
        maxProduct(Array(2, 3, -2, 4)) should be(6)
      }
    }

    "input: [-2, 0, -1]" should {
      "return 0" in {
        maxProduct(Array(-2, 0, -1)) should be(0)
      }
    }

    "input: [-2]" should {
      "return -2" in {
        maxProduct(Array(-2)) should be(-2)
      }
    }

    "input: [0, 2]" should {
      "return 2" in {
        maxProduct(Array(0, 2)) should be(2)
      }
    }

    "input: [-4, -3, -2]" should {
      "return 12" in {
        maxProduct(Array(-4, -3, -2)) should be(12)
      }
    }

    "input: [1, -3, 2]" should {
      "return 2" in {
        maxProduct(Array(1, -3, 2)) should be(2)
      }
    }

    "input: [2, -3, 1]" should {
      "return 2" in {
        maxProduct(Array(2, -3, 1)) should be(2)
      }
    }
  }
}
