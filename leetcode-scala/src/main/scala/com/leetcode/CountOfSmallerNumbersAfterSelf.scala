package com.leetcode

object CountOfSmallerNumbersAfterSelf {

  def countSmaller(nums: Array[Int]): List[Int] = {
    @scala.annotation.tailrec
    def loop(to: BiTree, value: Int, acc: Int): Int = {
      to.count += 1

      if (to.value < value) {
        if (to.right == null) {
          to.right = BiTree(value)
          acc + to.count - 1
        } else {
          loop(to.right, value, acc + to.count - to.right.count - 1)
        }
      } else if (to.value > value) {
        if (to.left == null) {
          to.left = BiTree(value)
          acc
        } else {
          loop(to.left, value, acc)
        }
      } else {
        acc + to.leftCount
      }
    }

    var result = 0 :: Nil
    val tree = BiTree(nums(nums.length - 1))

    for (i <- nums.length - 2 to 0 by -1) {
      result = loop(tree, nums(i), 0) :: result
    }

    result
  }

  private case class BiTree(
                             value: Int,
                             var count: Int = 1,
                             var left: BiTree = null,
                             var right: BiTree = null
                           ) {

    def leftCount: Int =
      if (left == null) 0
      else left.count
  }

  def main(args: Array[String]): Unit = {
    println(countSmaller(Array(65, 36, 100, 41)))
  }
}
