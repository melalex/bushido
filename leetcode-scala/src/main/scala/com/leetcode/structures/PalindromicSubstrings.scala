package com.leetcode.structures

object PalindromicSubstrings {

  def addBoundaries(string: String): String = {
    if (string == null || string.isEmpty) {
      return "^&"
    }

    val result = new Array[Char](string.length * 2 + 3)

    result(0) = '^'
    result(1) = '|'

    var i = 2

    for (char <- string) {
      result(i) = char
      result(i + 1) = '|'

      i = i + 2
    }

    result(result.length - 2) = '|'
    result(result.length - 1) = '$'

    result.mkString
  }

  def countSubstrings(s: String): Int = {
    val boundedString = addBoundaries(s)
    val palindromes = new Array[Int](boundedString.length)

    var center = 0
    var right = 0

    var i = 1

    while (i < boundedString.length - 1) {
      val mirror = 2 * center - i

      if (right > i) {
        palindromes(i) = Math.min(right - i, palindromes(mirror))
      }

      while (boundedString(i + palindromes(i) + 1) == boundedString(i - palindromes(i) - 1)) {
        palindromes(i) += 1
      }

      if (i + palindromes(i) > right) {
        center = i
        right = i + palindromes(i)
      }

      i += 1
    }

    palindromes.map(v => (v + 1) / 2).sum
  }
}
