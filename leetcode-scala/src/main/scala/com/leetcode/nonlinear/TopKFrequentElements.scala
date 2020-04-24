package com.leetcode.nonlinear

object TopKFrequentElements {

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = nums
    .groupMapReduce(e => e)(_ => 1)(_ + _)
    .toArray
    .sortBy(_._2)(Ordering.Int.reverse)
    .take(k)
    .map(_._1)
}
