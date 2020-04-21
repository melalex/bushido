package com.leetcode.nonlinear

import com.leetcode.TestSpec
import com.leetcode.nonlinear.NonOverlappingIntervals.eraseOverlapIntervals

class NonOverlappingIntervalsSpec extends TestSpec {

  "NonOverlappingIntervals" when {
    "input with 1 overlap" should {
      "remove the first" in {
        eraseOverlapIntervals(Array(Array(1, 3), Array(1, 2), Array(2, 3), Array(3, 4))) should be(1)
      }

      "remove in the middle" in {
        eraseOverlapIntervals(Array(Array(1, 2), Array(1, 3), Array(2, 3), Array(3, 4))) should be(1)
      }

      "remove the last" in {
        eraseOverlapIntervals(Array(Array(1, 2), Array(2, 3), Array(3, 4), Array(1, 3))) should be(1)
      }
    }

    "input 2 same intervals" should {
      "return 1" in {
        eraseOverlapIntervals(Array(Array(1, 2), Array(1, 2))) should be(1)
      }
    }

    "input 1 interval" should {
      "return 0" in {
        eraseOverlapIntervals(Array(Array(1, 2))) should be(0)
      }
    }

    "input 3 same intervals" should {
      "return 2" in {
        eraseOverlapIntervals(Array(Array(1, 2), Array(1, 2), Array(1, 2))) should be(2)
      }
    }

    "input without overlaps" should {
      "return 0" in {
        eraseOverlapIntervals(Array(Array(1, 2), Array(2, 3), Array(3, 4))) should be(0)
      }
    }

    "input [[0,2],[1,3],[2,4],[3,5],[4,6]]" should {
      "return 2" in {
        eraseOverlapIntervals(Array(Array(0, 2), Array(1, 3), Array(2, 4), Array(3, 5), Array(4, 6))) should be(2)
      }
    }

    "input [[0,2],[1,3],[1,3],[2,4],[3,5],[3,5],[4,6]]" should {
      "return 4" in {
        eraseOverlapIntervals(Array(Array(0, 2), Array(1, 3), Array(1, 3), Array(2, 4), Array(3, 5), Array(3, 5), Array(4, 6))) should be(4)
      }
    }
  }
}
