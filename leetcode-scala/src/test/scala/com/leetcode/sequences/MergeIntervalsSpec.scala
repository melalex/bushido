package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.MergeIntervals.merge

class MergeIntervalsSpec extends TestSpec {

  "MergeIntervals" when {
    "input: [[1,3],[2,6],[8,10],[15,18]]" should {
      "return [[1,6],[8,10],[15,18]]" in {
        merge(Array(Array(1, 3), Array(2, 6), Array(8, 10), Array(15, 18))) should be(Array(Array(1, 6), Array(8, 10), Array(15, 18)).reverse)
      }
    }

    "input: [[1,4],[4,5]]" should {
      "return [[1,5]]" in {
        merge(Array(Array(1, 4), Array(4, 5))) should be(Array(Array(1,5)))
      }
    }
  }
}
