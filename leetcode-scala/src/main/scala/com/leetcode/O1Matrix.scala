package com.leetcode

object O1Matrix {

//  def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
//    val m = mat.length
//    val n = mat(0).length
//    val result = Array.fill[Int](m, n)(Int.MaxValue)
//    val queue = new scala.collection.mutable.Queue[Pos]()
//
//    for {
//      i <- mat.indices
//      j <- mat(i).indices
//    } if (mat(i)(j) == 0) {
//      queue.enqueue(Pos(i, j, 0))
//    }
//
//    while (queue.nonEmpty) {
//      val Pos(i, j, dist) = queue.dequeue()
//
//      if (i >= 0 && i < m && j >= 0 && j < n && result(i)(j) > dist) {
//        result(i)(j) = dist
//
//        queue.enqueue(Pos(i + 1, j, dist + 1))
//        queue.enqueue(Pos(i, j + 1, dist + 1))
//        queue.enqueue(Pos(i - 1, j, dist + 1))
//        queue.enqueue(Pos(i, j - 1, dist + 1))
//      }
//    }
//
//    result
//  }
//
//  private case class Pos(i: Int, j: Int, dist: Int)

    def updateMatrix(mat: Array[Array[Int]]): Array[Array[Int]] = {
      val m = mat.length
      val n = mat(0).length
      val result = Array.ofDim[Int](m, n)

      def dfs(i: Int, j: Int): Int =
        if (i < 0 || i >= m || j < 0 || j >= n) Int.MaxValue
        else if (mat(i)(j) == 0) 0
        else if (result(i)(j) != 0) result(i)(j)
        else {
          val distance = math.min(dfs(i - 1, j), dfs(i, j - 1)) + 1

          result(i)(j) = distance

          distance
        }

      for {
        i <- mat.indices
        j <- mat(i).indices
      } {
        dfs(i, j)
      }

      result
    }

  def main(args: Array[String]): Unit = {
    println(
      updateMatrix(
        Array(
          Array(1, 0, 1, 1, 0, 0, 1, 0, 0, 1),
          Array(0, 1, 1, 0, 1, 0, 1, 0, 1, 1),
          Array(0, 0, 1, 0, 1, 0, 0, 1, 0, 0),
          Array(1, 0, 1, 0, 1, 1, 1, 1, 1, 1),
          Array(0, 1, 0, 1, 1, 0, 0, 0, 0, 1),
          Array(0, 0, 1, 0, 1, 1, 1, 0, 1, 0),
          Array(0, 1, 0, 1, 0, 1, 0, 0, 1, 1),
          Array(1, 0, 0, 0, 1, 1, 1, 1, 0, 1),
          Array(1, 1, 1, 1, 1, 1, 1, 0, 1, 0),
          Array(1, 1, 1, 1, 0, 1, 0, 0, 1, 1)
        )
      )
        .map(it => it.mkString("[", ",", "]\n"))
        .mkString("", "", "")
    )
  }
}
