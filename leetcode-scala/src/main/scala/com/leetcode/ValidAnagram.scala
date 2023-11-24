package com.leetcode

object ValidAnagram {

  type Occurrences = Map[Char, Int]

  /**
   * Given two strings s and t , write a function to determine if t is an anagram of s.
   *
   * @param s word
   * @param t word
   * @return true if t is anagram of s and false otherwise
   */
  def isAnagram(s: String, t: String): Boolean = occurrences(s) == occurrences(t)

  @inline
  def occurrences(word: String): Occurrences = word.groupMapReduce(identity)(_ => 1)(_ + _)
}
