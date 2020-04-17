package com.leetcode.structures

object LengthOfLongestSubstring {

  def lengthOfLongestSubstring(s: String): Int = {
    var maxSize = 0
    var left = 0
    var right = 0
    val map = collection.mutable.Map[Char, Int]()

    while (right < s.length) {
      val char = s(right)

      if (map.contains(char)) {
        left = Math.max(map(char), left)
      }

      maxSize = Math.max(maxSize, right - left + 1)

      map(char) = right + 1
      right += 1
    }

    maxSize
  }
}
