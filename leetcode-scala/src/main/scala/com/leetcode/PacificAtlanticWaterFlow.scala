package com.leetcode

object PacificAtlanticWaterFlow {

  private val PACIFIC = 2
  private val ATLANTIC = 4

  def pacificAtlantic(matrix: Array[Array[Int]]): List[List[Int]] = {
    if (matrix == null || matrix.isEmpty) {
      return Nil
    }

    val n = matrix.length
    val m = matrix(0).length
    val length = n * m

    val waterFlows = new Array[Int](length)

    @inline
    def toWaterFlowsIndex(i: Int, j: Int): Int = i * m + j

    @inline
    def isFlowsIntoBothOceans(value: Int): Boolean = (value & PACIFIC) != 0 && (value & ATLANTIC) != 0

    @inline
    def getWaterFlows(i: Int, j: Int): Int = waterFlows(toWaterFlowsIndex(i, j))

    def dfs(i: Int, j: Int, prevHeight: Int, ocean: Int): Unit = {
      if (i < 0 || j < 0 || i >= n || j >= m) {
        return
      }

      val index = toWaterFlowsIndex(i, j)

      if ((waterFlows(index) & ocean) == ocean) {
        return
      }

      val currentHeight = matrix(i)(j)

      if (currentHeight < prevHeight) {
        return
      }

      waterFlows(index) |= ocean

      dfs(i - 1, j, currentHeight, ocean)
      dfs(i, j - 1, currentHeight, ocean)
      dfs(i + 1, j, currentHeight, ocean)
      dfs(i, j + 1, currentHeight, ocean)
    }

    def calculateWaterFlow(): Unit = {
      var i = 0
      var j = 0

      while (i < n) {
        dfs(i, 0, Int.MinValue, PACIFIC)
        dfs(i, m - 1, Int.MinValue, ATLANTIC)
        i += 1
      }

      while (j < m) {
        dfs(0, j, Int.MinValue, PACIFIC)
        dfs(n - 1, m - j - 1, Int.MinValue, ATLANTIC)
        j += 1
      }
    }

    @scala.annotation.tailrec
    def traverseWaterFlows(i: Int, j: Int, acc: List[List[Int]]): List[List[Int]] =
      if (i >= n) acc
      else if (j >= m) traverseWaterFlows(i + 1, 0, acc)
      else if (isFlowsIntoBothOceans(getWaterFlows(i, j))) traverseWaterFlows(i, j + 1, List(i, j) :: acc)
      else traverseWaterFlows(i, j + 1, acc)


    calculateWaterFlow()

    traverseWaterFlows(0, 0, Nil)
  }
}
