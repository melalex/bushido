package com.leetcode.structures

import com.leetcode.{NumberOfIslands, TestSpec}

class NumberOfIslandsSpec extends TestSpec {

  "NumberOfIslands" when {
    "sea has 1 island" should {
      "return 1" in {
        val sea =
          """11110
            |11010
            |11000
            |00000"""
            .stripMargin
            .linesIterator.map(_.toCharArray)
            .toArray

        NumberOfIslands.numIslands(sea) should be(1)
        1
      }
    }

    "sea has 3 island" should {
      "return 3" in {
        val sea =
          """11000
            |11000
            |00100
            |00011"""
            .stripMargin
            .linesIterator.map(_.toCharArray)
            .toArray

        NumberOfIslands.numIslands(sea) should be(3)
        1
      }
    }

    "1d sea" should {
      "return 3" in {
        val sea = "1011011"
          .linesIterator.map(_.toCharArray)
          .toArray

        NumberOfIslands.numIslands(sea) should be(3)
        1
      }
    }
  }
}
