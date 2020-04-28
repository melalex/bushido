package com.leetcode.advanced

object InsertInterval {

  def insert(intervals: Array[Array[Int]], newInterval: Array[Int]): Array[Array[Int]] = {

    if (intervals.isEmpty) {
      return Array(newInterval)
    }

    val buffer = collection.mutable.ArrayBuffer[Array[Int]]()

    def overlaps(a: Array[Int], b: Array[Int]): Boolean =
      (a(0) >= b(0) && a(0) <= b(1)) ||
        (a(1) >= b(0) && a(1) <= b(1)) ||
        (b(1) >= a(0) && b(1) <= a(1)) ||
        (b(1) >= a(0) && b(1) <= a(1))

    def shouldInsert(interval: Array[Int], i: Int): Boolean =
      (i >= intervals.length && (buffer.isEmpty || buffer.last(1) < interval(0))) ||
        ((buffer.isEmpty || interval(0) > buffer.last(1)) && interval(1) < intervals(i)(0))

    def merge(a: Array[Int], b: Array[Int]): Array[Int] = Array(Math.min(a(0), b(0)), Math.max(a(1), b(1)))

    var target = newInterval
    var i = 0

    while (i <= intervals.length) {

      while (i < intervals.length && overlaps(target, intervals(i))) {
        target = merge(target, intervals(i))
        i += 1
      }

      if (shouldInsert(target, i)) {
        buffer += target
      } else {
        if (i < intervals.length) buffer += intervals(i)

        i += 1
      }
    }

    buffer.toArray
  }
}
