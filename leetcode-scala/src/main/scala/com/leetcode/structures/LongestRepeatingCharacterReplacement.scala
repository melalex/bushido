package com.leetcode.structures

object LongestRepeatingCharacterReplacement {

  def characterReplacement(s: String, k: Int): Int = {

    def pos(i: Int): Int = s(i) - 'A'

    val chars = Array.ofDim[Int](26)
    var left = 0
    var right = 0
    var maxCount = 0
    var maxLength = 0

    while (right < s.length) {
      chars(pos(right)) += 1
      maxCount = Math.max(maxCount, chars(pos(right)))

      while (right - left + 1 - maxCount > k) {
        chars(pos(left)) -= 1
        left += 1
      }

      maxLength = Math.max(maxLength, right - left + 1)
      right += 1
    }

    maxLength
  }
}
