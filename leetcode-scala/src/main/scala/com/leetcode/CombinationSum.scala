package com.leetcode

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

  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val queue = new scala.collection.mutable.Queue[Frame]()
    var result = List[List[Int]]()

    queue.enqueue(Frame(target, candidates.toList, Nil))

    while (queue.nonEmpty) {
      val Frame(remaining, candidates, acc) = queue.dequeue()

      if (remaining == 0) {
        result = acc :: result
      } else if (candidates.nonEmpty && remaining > 0) {
        queue.enqueue(Frame(remaining - candidates.head, candidates, candidates.head :: acc))
        queue.enqueue(Frame(remaining, candidates.tail, acc))
      }
    }

    result
  }

  private case class Frame(remaining: Int, candidates: List[Int], acc: List[Int])
}
