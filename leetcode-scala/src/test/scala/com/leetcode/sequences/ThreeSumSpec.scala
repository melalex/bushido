package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.ThreeSum.threeSum

class ThreeSumSpec extends TestSpec {

  "ThreeSum" when {
    "input: [-1, 0, 1, 2, -1, -4]" should {
      "return [[-1, 0, 1], [-1, -1, 2]]" in {
        val actual = threeSum(Array(-1, 0, 1, 2, -1, -4))
          .map(_.toSet)
          .toSet

        val expected = Set(Set(-1, 0, 1), Set(-1, -1, 2))

        actual should be(expected)
      }
    }
  }
}
