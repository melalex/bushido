package com.leetcode.advanced

object InsertInterval {

  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {
    val buffer = collection.mutable.ArrayBuffer[Array[Int]]()
    var target = newInterval

    for (interval <- intervals) {
      if (interval(1) < target(0)) {
        buffer += interval
      } else if (interval(0) > target(1)) {
        buffer += target
        target = interval
      } else {
        target = Array(Math.min(interval(0), target(0)), Math.max(interval(1), target(1)))
      }
    }

    buffer.append(target).toArray
  }
}
