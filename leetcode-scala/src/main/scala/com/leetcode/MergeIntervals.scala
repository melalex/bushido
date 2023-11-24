package com.leetcode

object MergeIntervals {

  def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
    if (intervals.isEmpty) {
      return Array.empty
    }

    val sorted = intervals.sortBy(_.head)
    var result = sorted.head :: Nil

    for (elem <- sorted.tail) {
      val head = result.head

      if (head(1) >= elem(0)) {
        result = Array(head(0), Math.max(head(1), elem(1))) :: result.tail
      } else {
        result = elem :: result
      }
    }

    result.toArray
  }
}
