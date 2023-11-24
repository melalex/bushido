package com.leetcode

object JumpGame3 {

  import scala.collection.mutable

  def canReach(arr: Array[Int], start: Int): Boolean = {
    val queue = mutable.Queue(start)
    val visited = new Array[Boolean](arr.length)

    while (queue.nonEmpty) {
      val pos = queue.dequeue()

      if (arr(pos) == 0) return true
      else {
        val currentValue = arr(pos)
        val left = pos - currentValue
        val right = pos + currentValue

        visited(pos) = true

        if (left >= 0 && left < arr.length && !visited(left)) queue += left
        if (right >= 0 && right < arr.length && !visited(right)) queue += right
      }
    }

    false
  }

  def main(args: Array[String]): Unit = {

  }
}
