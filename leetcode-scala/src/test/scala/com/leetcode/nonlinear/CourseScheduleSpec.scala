package com.leetcode.nonlinear

import com.leetcode.TestSpec
import com.leetcode.CourseSchedule.canFinish

class CourseScheduleSpec extends TestSpec {

  "CourseScheduleSpec" when {
    "input empty array" should {
      "return true" in {
        canFinish(1, Array()) should be(true)
      }
    }

    "input [[1,0]]" should {
      "return true" in {
        canFinish(2, Array(Array(1, 0))) should be(true)
      }
    }

    "input [[1,0],[0,1]]" should {
      "return false" in {
        canFinish(2, Array(Array(1, 0), Array(0, 1))) should be(false)
      }
    }

    "input [[2,0],[1,0],[3,1],[3,2],[1,3]]" should {
      "return false" in {
        canFinish(4, Array(Array(2, 0), Array(1, 0), Array(3, 1), Array(3, 2), Array(1, 3))) should be(false)
      }
    }

    "input [[0,1],[3,1],[1,3],[3,2]]" should {
      "return false" in {
        canFinish(4, Array(Array(0, 1), Array(3, 1), Array(1, 3), Array(3, 2))) should be(false)
      }
    }

    "input [[0,1],[0,2],[1,2]]" should {
      "return true" in {
        canFinish(3, Array(Array(0, 1), Array(0, 2), Array(1, 2))) should be(true)
      }
    }
  }
}
