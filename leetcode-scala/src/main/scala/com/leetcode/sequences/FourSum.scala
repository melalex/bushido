package com.leetcode.sequences

object FourSum {

  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {

    def fourSumInternal(nums: Map[Int, Int]) = {
      var res = List[List[Int]]()

      for ((i, value) <- nums) {
        for (subSum <- threeSum(nums - i, target - value)) {
          res = (value :: subSum) :: res
        }
      }

      res
    }

    def threeSum(nums: Map[Int, Int], target: Int): List[List[Int]] = {
      var res = List[List[Int]]()

      for ((i, value) <- nums) {
        val subSum = twoSum(nums - i, target - value)

        if (subSum.nonEmpty) {
          res = (value :: subSum) :: res
        }
      }

      res
    }

    def twoSum(nums: Map[Int, Int], target: Int): List[Int] = {
      val index = nums.values.toSet

      for ((_, value) <- nums) {
        if (index.contains(target - value)) {
          return List(value, target - value)
        }
      }

      Nil
    }

    fourSumInternal(nums.zipWithIndex.map(it => it._2 -> it._1).toMap)
  }

  def main(arg: Array[String]): Unit = {
    println(fourSum(Array(1, 0, -1, 0, -2, 2), 0))
  }
}
