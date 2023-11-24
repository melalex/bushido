package com.leetcode

object JumpGame7 {

  import scala.collection.mutable

  def canReach(s: String, minJump: Int, maxJump: Int): Boolean = {
    if (s.last == '1')
      return false

    val couldLand = new mutable.BitSet()
    couldLand(0) = true

    for (i <- 0 until s.length) {
      if (couldLand(i)) {
        for (j <- (i + minJump) to Math.min(i + maxJump, s.length - 1)) {
          couldLand(j) = s(j) == '0'
        }
      }
    }

    couldLand(s.length - 1)
  }

  def main(args: Array[String]): Unit = {
    println(canReach("011000001011110000", 4, 7))
    println(canReach("011010", 2, 7))
  }
}
