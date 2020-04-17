package com.leetcode.structures

object MinimumWindowSubstring {

  def minWindow(s: String, t: String): String = {
    val chars = t.groupMapReduce(identity)(_ => 1)(_ + _)
    val length = s.length
    val occurrences = collection.mutable.Map[Char, Int]().withDefault(_ => 0)

    def findLeftest(startIndex: Int): Int = {
      var i = startIndex
      while (i < length) {
        val char = s(i)

        if (chars.contains(char) && occurrences(char) > chars(char)) {
          occurrences(char) = occurrences(char) - 1
        } else if (chars.contains(char)) {
          return i
        }

        i += 1
      }

      length - 1
    }

    def enough() = chars.forall { case (c, i) => occurrences(c) >= i }

    var left = findLeftest(0)
    var right = left
    var minLeft = left
    var minRight = left

    while (right < length) {
      val char = s(right)

      if (chars.contains(char)) {
        val leftChar = s(left)

        if (leftChar == char && occurrences(leftChar) >= chars(leftChar)) {
          left = findLeftest(left + 1)
        } else {
          occurrences(char) = occurrences(char) + 1
        }

        if (enough()) {
          if (right - left + 1 < minRight - minLeft || minRight - minLeft == 0) {
            minLeft = left
            minRight = right + 1
          }

          occurrences(leftChar) = occurrences(leftChar) - 1
          left = findLeftest(left + 1)
        }
      }

      right += 1
    }

    s.substring(minLeft, minRight)
  }
}
