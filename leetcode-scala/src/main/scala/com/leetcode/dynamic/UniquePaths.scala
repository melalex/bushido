package com.leetcode.dynamic

object UniquePaths {

  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Matrix(n, m)

    dp(0, 0) = 1

    for (i <- 0 until n) {
      for (j <- 0 until m) {
        if (i != 0 || j !=0 ) {
          dp(i, j) = dp(i - 1, j) + dp(i, j - 1)
        }
      }
    }

    dp.last
  }

  private case class Matrix(n: Int, m: Int) {

    private val array = new Array[Int](m * n)

    def last: Int = array(index(n - 1, m - 1))

    def apply(i: Int, j: Int): Int =
      if (i < 0 || i >= n || j < 0 || j >= m) 0
      else array(index(i, j))

    def update(i: Int, j: Int, value: Int): Unit = array(index(i, j)) = value

    private def index(i: Int, j: Int) = i * m + j
  }

}
