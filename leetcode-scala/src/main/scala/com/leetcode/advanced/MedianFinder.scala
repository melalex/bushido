package com.leetcode.advanced

class MedianFinder {

  import scala.collection.mutable

  private val high = mutable.PriorityQueue[Int]()(Ordering.Int.reverse)
  private val low = mutable.PriorityQueue[Int]()

  def addNum(num: Int) {
    high += num

    val min = high.dequeue()

    low += min

    if (low.size > high.size) {
      val max = low.dequeue()

      high += max
    }
  }

  def findMedian(): Double =
    if (((high.length + low.length) & 1) == 0) (low.head + high.head) / 2.0
    else high.head
}
