package com.leetcode.structures

import com.leetcode.TestSpec
import com.leetcode.structures.PacificAtlanticWaterFlow.pacificAtlantic

class PacificAtlanticWaterFlowSpec extends TestSpec {

  "PacificAtlanticWaterFlow" when {
    "input matrix" should {
      "return expected result" in {
        val matrix =
          """12235
            |32344
            |24531
            |67145
            |51124""".stripMargin

        pacificAtlantic(asIntMatrix(matrix)).toSet should be(Set(List(0, 4), List(1, 3), List(1, 4), List(2, 2), List(3, 0), List(3, 1), List(4, 0)))
      }
    }

    "input box" should {
      "return expected result" in {
        val matrix =
          """999
            |919
            |999
            |""".stripMargin

        pacificAtlantic(asIntMatrix(matrix)).toSet should be(Set(List(0, 0), List(0, 1), List(0, 2), List(1, 0), List(1, 2), List(2, 0), List(2, 1), List(2, 2)))
      }
    }
  }
}
