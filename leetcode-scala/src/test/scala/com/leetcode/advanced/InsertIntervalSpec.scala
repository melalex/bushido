package com.leetcode.advanced

import com.leetcode.TestSpec
import com.leetcode.InsertInterval.insert

class InsertIntervalSpec extends TestSpec {

  "InsertInterval" when {
    "intervals = [[1,3],[6,9]], newInterval = [2,5]" should {
      "return [[1,5],[6,9]]" in {
        insert(Array(Array(1, 3), Array(6, 9)), Array(2, 5)) should be(Array(Array(1, 5), Array(6, 9)))
      }
    }

    "intervals = [[1,5]], newInterval = [2,3]" should {
      "return [[1,5]]" in {
        insert(Array(Array(1, 5)), Array(2, 3)) should be(Array(Array(1, 5)))
      }
    }

    "intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]" should {
      "return [[1,5],[6,9]]" in {
        insert(Array(Array(1, 2), Array(3, 5), Array(6, 7), Array(8, 10), Array(12, 16)), Array(4, 8)) should be(Array(Array(1, 2), Array(3, 10), Array(12, 16)))
      }
    }
  }
}
