package com.leetcode

object Subsets {

  def subsets(nums: Array[Int]): List[List[Int]] = {
    def loop(i: Int, acc: List[Int]): List[List[Int]] =
      if (i >= nums.length) List(acc)
      else loop(i + 1, nums(i) :: acc) ::: loop(i + 1, acc)

    loop(0, Nil)
  }
}
