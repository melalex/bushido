package com.leetcode.advanced

import scala.annotation.tailrec

object CountSmaller {

  case class Tree(
                   value: Int,
                   var left: Tree = null,
                   var right: Tree = null,
                   var height: Int = 1,
                 )

  def countSmaller(nums: Array[Int]): List[Int] = {
    @tailrec
    def addToTree(tree: Tree, value: Int, acc: Int): Int = {
      tree.height += 1
      if (value > tree.value) {
        val newAcc = acc + 1 + (if(tree.left != null) tree.left.height else 0)
        if (tree.right == null) {
          tree.right = Tree(value)
          newAcc
        }
        else addToTree(tree.right, value, newAcc)
      }
      else if (tree.left == null) {
        tree.left = Tree(value)
        acc
      }
      else addToTree(tree.left, value, acc)
    }

    if (nums.isEmpty) {
      return Nil
    }

    val root = Tree(nums(nums.length - 1))
    var result = 0 :: Nil

    for (i <- nums.length - 2 to 0 by -1) {
      result = addToTree(root, nums(i), 0) :: result
    }

    result
  }

  def main(args: Array[String]): Unit = {
    println(countSmaller(Array(5, 2, 6, 1)))
  }
}
