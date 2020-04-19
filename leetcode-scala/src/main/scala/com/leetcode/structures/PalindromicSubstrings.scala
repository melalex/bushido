package com.leetcode.structures

object PalindromicSubstrings {

  def countSubstrings(s: String): Int = {
    def isPalindromic(from: Int, until: Int): Boolean = {
      var i = 0

      while (i < (until - from) / 2 + 1) {
        if (s(until - i) != s(from + i)) {
          return false
        }

        i += 1
      }

      true
    }

    val indices = s.zipWithIndex
      .groupMap(t => t._1)(t => t._2)
    var result = 0

    for ((_, value) <- indices) {
      var i = 0

      while (i < value.length) {
        var j = value.length - 1

        while (j >= i) {
          val from = value(i)
          val until = value(j)

          if (isPalindromic(from, until)) {
            result += 1
          }

          j -= 1
        }

        i += 1
      }
    }

    result
  }
}
