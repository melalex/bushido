package com.leetcode.advanced

import scala.annotation.tailrec

object CountSmaller {

//  case class Tree(
//                   var left: Tree,
//                   var right: Tree,
//                   index: Int,
//                 )
//
//  def countSmaller(nums: Array[Int]): List[Int] = {
//    if (nums.isEmpty) {
//      return List.empty
//    }
//
//    val result = Array.ofDim[Int](nums.length)
//
//    @tailrec
//    def addToTree(currentNode: Tree, i: Int, value: Int): Unit =
//      if (nums(currentNode.index) > value) {
//        result(currentNode.index) += 1
//        increment(currentNode.right)
//
//        if (currentNode.left != null) {
//          addToTree(currentNode.left, i, value)
//        } else {
//          currentNode.left = Tree(null, null, i)
//        }
//      } else if (currentNode.right != null) {
//        addToTree(currentNode.right, i, value)
//      } else {
//        currentNode.right = Tree(null, null, i)
//      }
//
//    def increment(tree: Tree): Unit =
//      if (tree == null) ()
//      else {
//        result(tree.index) += 1
//
//        increment(tree.left)
//        increment(tree.right)
//      }
//
//    val root = Tree(null, null, 0)
//
//    for (i <- 1 until nums.length) {
//      addToTree(root, i, nums(i))
//    }
//
//    result.toList
//  }

  def countSmaller(nums: Array[Int]): List[Int] = {
    val valToIndex = nums.zipWithIndex.groupMap(_._1)(_._2)

    val sorted = nums.sorted
    var result = List[Int]()



    result
  }


  def main(args: Array[String]): Unit = {
    println(countSmaller(Array(5, 2, 6, 1)))
  }
}
