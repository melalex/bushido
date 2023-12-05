package com.leetcode

object PartitionEqualSubsetSum {

  def canPartition(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    val halfSum = sum / 2
    val visited = scala.collection.mutable.Set[(Int, Int)]()

    def loop(subSum: Int, i: Int): Boolean =
      if (subSum == halfSum) true
      else if (subSum > halfSum || i >= nums.length || visited(subSum -> i)) false
      else {
        val result = loop(subSum + nums(i), i + 1) || loop(subSum, i + 1)
        visited += subSum -> i
        result
      }

    if ((sum & 1) == 0) loop(0, 0)
    else false
  }

  def main(args: Array[String]): Unit = {
    println(canPartition(Array(1,2,3,5,17,6,14,12,6)))
  }
}
