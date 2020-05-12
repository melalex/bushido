package com.leetcode.dynamic

import com.leetcode.TestSpec
import com.leetcode.dynamic.UniquePaths.uniquePaths

class UniquePathsSpec extends TestSpec {

  "UniquePaths" when {
    "input 3,2" should {
      "return 3" in {
        uniquePaths(3, 2) should be(3)
      }
    }
  }
}
