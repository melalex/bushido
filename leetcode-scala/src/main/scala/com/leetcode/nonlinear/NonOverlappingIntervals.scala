package com.leetcode.nonlinear

object NonOverlappingIntervals {

  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    if (intervals == null || intervals.isEmpty) {
      return 0
    }

    val n = intervals.length
    val matrix = new Array[Int](n * n)
    var i = 0

    @inline
    def index(i: Int, j: Int): Int = i * n + j

    def isOverlap(a: Array[Int], b: Array[Int]): Boolean = a(1) > b(0) && b(1) > a(0)

    while (i < n) {
      var j = 0

      while (j < n) {
        if (i != j && isOverlap(intervals(i), intervals(j))) {
          matrix(index(i, j)) = 1
          matrix(index(j, i)) = 1
        }

        j += 1
      }

      i += 1
    }


    0
  }
}
