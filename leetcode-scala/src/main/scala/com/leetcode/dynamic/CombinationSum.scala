package com.leetcode.dynamic

object CombinationSum {

  def combinationSum4(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty) {
      return 0
    }

    val visited = collection.mutable.Map[Int, Int]()

    def visit(acc: Int, res: Int): Int = {
      visited(acc) = res

      res
    }

    def iter(acc: Int): Int =
      if (acc == target) 1
      else if (visited.contains(acc)) visited(acc)
      else if (acc > target) 0
      else visit(acc, nums.map(num => iter(acc + num)).sum)

    iter(0)
  }
}
