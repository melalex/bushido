package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.ContainsDuplicate._

class ContainsDuplicateSpec extends TestSpec {

  "Contains duplicate" when {
    "input: [1, 2, 3, 1]" should {
      "return true" in {
        containsDuplicate(Array(1, 2, 3, 1)) should be(true)
      }
    }

    "input: [1, 2, 3, 4]" should {
      "return false" in {
        containsDuplicate(Array(1, 2, 3, 4)) should be(false)
      }
    }

    "input: [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]" should {
      "return true" in {
        containsDuplicate(Array(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)) should be(true)
      }
    }
  }
}
