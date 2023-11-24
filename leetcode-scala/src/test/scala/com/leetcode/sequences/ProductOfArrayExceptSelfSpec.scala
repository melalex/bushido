package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.ProductOfArrayExceptSelf.productExceptSelf

class ProductOfArrayExceptSelfSpec extends TestSpec {

  "ProductOfArrayExceptSelf" when {
    "input: [1,2,3,4]" should {
      "return [24,12,8,6]" in {
        productExceptSelf(Array(1, 2, 3, 4)) should be(Array(24, 12, 8, 6))
      }
    }

    "long input" should {
      "handle it" in {
        productExceptSelf(Array.fill(124990)(1)) should be(Array.fill(124990)(1))
      }
    }
  }
}
