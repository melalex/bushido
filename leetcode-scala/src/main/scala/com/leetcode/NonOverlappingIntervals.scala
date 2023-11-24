package com.leetcode

object NonOverlappingIntervals {

  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    val sorted = intervals.sortBy(a => a(1))
    var currentEnd = Int.MinValue
    var minOverlapsCount = 0

    for (interval <- sorted) {
      if (interval(0) >= currentEnd) {
        currentEnd = interval(1)
        minOverlapsCount += 1
      }
    }

    intervals.length - minOverlapsCount
  }
}
