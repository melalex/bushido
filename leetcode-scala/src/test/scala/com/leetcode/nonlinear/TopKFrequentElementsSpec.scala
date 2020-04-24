package com.leetcode.nonlinear

import com.leetcode.TestSpec

class TopKFrequentElementsSpec extends TestSpec{

  "TopKFrequentElements" when {
    "input nums = [1,1,1,2,2,3], k = 2" should {
      "return [1,2]" in {
        TopKFrequentElements.topKFrequent(Array(1,1,1,2,2,3), 2).toSet should be(Set(1,2))
      }
    }
  }
}
