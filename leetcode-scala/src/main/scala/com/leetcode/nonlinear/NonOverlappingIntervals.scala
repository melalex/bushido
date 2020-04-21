package com.leetcode.nonlinear

object NonOverlappingIntervals {

  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    if (intervals == null || intervals.isEmpty) {
      return 0
    }

    val n = intervals.length
    val matrix = new Array[Int](n * n)

    def removeByIndex(target: Int): Unit = {
      var i = 0

      println()
      println(s"Cleaning $target")
      println()

      while (i < n) {
        matrix(index(i, target)) = 0
        matrix(index(target, i)) = 0

        i += 1
      }
    }

    def maxOverlaps(): Int = {
      var i = 0
      var max = 0
      var maxIndex = -1

      while (i < n) {
        var j = 0
        var acc = 0

        while (j < n) {
          acc += matrix(index(i, j))
          acc += matrix(index(j, i))

          j += 1
        }

        println()
        println(s"A[$i] = $acc")
        println()

        if (acc > max) {
          max = acc
          maxIndex = i
        }

        i += 1
      }

      maxIndex
    }

    def printMatrix(): Unit = {
      var i = 0
      while (i < n) {
        var j = 0
        while (j < n) {
          print(matrix(index(i, j)) + " ")
          j += 1
        }
        println()
        i += 1
      }
      println()
    }

    @inline
    def index(i: Int, j: Int): Int = i * n + j

    @inline
    def isOverlap(a: Array[Int], b: Array[Int]): Boolean = a(1) > b(0) && b(1) > a(0)

    var i = 0

    while (i < n) {
      var j = 0

      while (j < n) {
        if (i != j && isOverlap(intervals(i), intervals(j))) {
          matrix(index(i, j)) = 1
        }

        j += 1
      }

      i += 1
    }

    printMatrix()

    var count = 0
    while (matrix.exists(_ > 0)) {
      removeByIndex(maxOverlaps())
      printMatrix()

      count += 1
    }

    count
  }
}
