package com.leetcode

object PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

  def minPartitions(n: String): Int = {
    var max = '0'

    for (ch <- n) {
      if (ch > max) {
        max = ch
      }
    }

    max.toInt - '0'.toInt
  }
}
