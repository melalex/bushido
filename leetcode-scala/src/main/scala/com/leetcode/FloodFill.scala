package com.leetcode

object FloodFill {

  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, color: Int): Array[Array[Int]] = {
    val target = image(sr)(sc)
    val m = image.length
    val n = image(0).length

    def fillInternal(i: Int, j: Int): Unit =
      if (i >= 0 && i < m && j >= 0 && j < n && image(i)(j) == target) {
        image(i)(j) = color

        fillInternal(i + 1, j)
        fillInternal(i, j + 1)
        fillInternal(i - 1, j)
        fillInternal(i, j - 1)
      }

    if (target != color) {
      fillInternal(sr, sc)
    }

    image
  }

  def main(args: Array[String]): Unit = {
    println(floodFill(Array(Array(0, 0, 0), Array(0, 0, 0), Array(0, 0, 0)), 0, 0, 0).map(_.mkString).mkString)
  }
}
