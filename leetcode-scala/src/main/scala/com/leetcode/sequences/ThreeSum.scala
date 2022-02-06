package com.leetcode.sequences

object ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val mapping = nums.zipWithIndex
      .map { case (n, i) => n -> i }
      .toMap

    val resultBuilder = scala.collection.mutable.Set[List[Int]]()

    for (i <- nums.indices) {
      for (j <- i + 1 until nums.length) {
        val subSum = -(nums(i) + nums(j))
        if (mapping.contains(subSum)) {
          val thirdIndex = mapping(subSum)
          if (thirdIndex != i && thirdIndex != j) {
            resultBuilder += List(nums(i), nums(j), subSum).sorted
          }
        }
      }
    }

    resultBuilder.toList
  }
}
