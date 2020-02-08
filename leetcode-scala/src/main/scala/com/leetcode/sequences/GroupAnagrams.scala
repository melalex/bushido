package com.leetcode.sequences

object GroupAnagrams {

  type Occurrences = Map[Char, Int]

  def groupAnagrams(strs: Array[String]): List[List[String]] = strs
    .groupBy(occurrences)
    .values
    .map(_.toList)
    .toList

  def occurrences(word: String): Occurrences = word.groupMapReduce(identity)(_ => 1)(_ + _)
}
