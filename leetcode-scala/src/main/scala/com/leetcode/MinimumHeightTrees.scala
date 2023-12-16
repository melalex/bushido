package com.leetcode

object MinimumHeightTrees {

  def findMinHeightTrees(n: Int, edges: Array[Array[Int]]): List[Int] = {
    if (n == 1) {
      return List(0)
    }

    val vertices = Array.fill(n)(scala.collection.mutable.ArrayBuffer[Int]())
    val neighbors = Array.ofDim[Int](n)

    for (edge <- edges) {
      val left = edge(0)
      val right = edge(1)

      vertices(left) += right
      vertices(right) += left

      neighbors(left) += 1
      neighbors(right) += 1
    }

    val leaves = collection.mutable.Queue[Int]()

    for (i <- 0 until n ) {
      if (neighbors(i) == 1) {
        leaves.enqueue(i)
      }
    }

    var remainingNodes = n

    while (remainingNodes > 2) {
      for (_ <- leaves.indices) {
        val leaf = leaves.dequeue()
        remainingNodes -= 1

        for (it <- vertices(leaf)) {
          neighbors(it) -= 1

          if (neighbors(it) == 1) {
            leaves.enqueue(it)
          }
        }
      }
    }

    leaves.toList
  }
}
