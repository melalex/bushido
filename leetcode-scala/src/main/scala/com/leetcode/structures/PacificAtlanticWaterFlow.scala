package com.leetcode.structures

object PacificAtlanticWaterFlow {

  private val NO_VALUE = 0
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

    def updateWaterFlow(i: Int, j: Int, inc: Int): Unit = {
      if (i < 0 || j < 0 || i >= n || j >= m) {
        return
      }

      val index = toWaterFlowsIndex(i, j)
      val oldValue = waterFlows(index)
      val newValue = oldValue | inc

      if (newValue != oldValue) {
        waterFlows(index) = newValue

        if (i > 0 && matrix(i)(j) <= matrix(i - 1)(j)) updateWaterFlow(i - 1, j, newValue)
        if (j > 0 && matrix(i)(j) <= matrix(i)(j - 1)) updateWaterFlow(i, j - 1, newValue)
        if (i < n - 1 && matrix(i)(j) <= matrix(i + 1)(j)) updateWaterFlow(i + 1, j, newValue)
        if (j < m - 1 && matrix(i)(j) <= matrix(i)(j + 1)) updateWaterFlow(i, j + 1, newValue)
      }
    }

    def calculateWaterFlowIn(i: Int, j: Int): Int = {
      val up =
        if (i == 0) PACIFIC
        else if (matrix(i)(j) >= matrix(i - 1)(j)) getWaterFlows(i - 1, j)
        else NO_VALUE

      val left =
        if (j == 0) PACIFIC
        else if (matrix(i)(j) >= matrix(i)(j - 1)) getWaterFlows(i, j - 1)
        else NO_VALUE

      val down =
        if (i == n - 1) ATLANTIC
        else if (matrix(i)(j) >= matrix(i + 1)(j)) getWaterFlows(i + 1, j)
        else NO_VALUE

      val right =
        if (j == m - 1) ATLANTIC
        else if (matrix(i)(j) >= matrix(i)(j + 1)) getWaterFlows(i, j + 1)
        else NO_VALUE

      up | left | down | right
    }

    @scala.annotation.tailrec
    def calculateWaterFlow(i: Int, j: Int): Unit =
      if (j >= m) calculateWaterFlow(i + 1, 0)
      else if (i < n) {
        updateWaterFlow(i, j, calculateWaterFlowIn(i, j))
        calculateWaterFlow(i, j + 1)
      }

    @scala.annotation.tailrec
    def traverseWaterFlows(i: Int, j: Int, acc: List[List[Int]]): List[List[Int]] =
      if (i >= n) acc
      else if (j >= m) traverseWaterFlows(i + 1, 0, acc)
      else if (isFlowsIntoBothOceans(getWaterFlows(i, j))) traverseWaterFlows(i, j + 1, List(i, j) :: acc)
      else traverseWaterFlows(i, j + 1, acc)

    calculateWaterFlow(0, 0)

    traverseWaterFlows(0, 0, Nil)
  }
}
