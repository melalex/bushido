package com.leetcode.sequences

object LongestRepeatingCharacterReplacement {

  def characterReplacement(s: String, k: Int): Int = {
    var i = 0
    val map = scala.collection.mutable.Map[Char, Vector[CharRange]]()
      .withDefault(_ => scala.collection.mutable.Vector[CharRange]())

    while (i < s.length) {
      val char = s(i)
      val vector = map(char)

      if (vector.isEmpty || vector.last.to != i) {
        vector.appended(CharRange(i, i + 1))
      } else {
        vector.last.to = i + 1
      }

      i += 1
    }


  }

  case class CharRange(from: Int, var to: Int)
}
