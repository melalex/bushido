package com.leetcode.dynamic

object UniquePaths {

  def uniquePaths(m: Int, n: Int): Int = {
    val dp = new Array[Int](m * n)

    def cache(i: Int, j: Int, value: Int): Int = {
      dp(index(i, j)) = value

      value
    }

    def index(i: Int, j: Int): Int = i * m + j

    def iter(i: Int, j: Int): Int = {
      if (i >= n || j >= m) 0
      else if (dp(index(i, j)) != 0) dp(index(i, j))
      else if (i == n - 1 && j == m - 1) 1
      else cache(i, j, iter(i + 1, j) + iter(i, j + 1))
    }

    iter(0, 0)
  }
}
