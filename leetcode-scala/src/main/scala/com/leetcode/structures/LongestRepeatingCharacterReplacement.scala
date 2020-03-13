package com.leetcode.structures

object LongestRepeatingCharacterReplacement {

  import scala.collection.mutable

  def characterReplacement(s: String, k: Int): Int = {
    val map = mutable.Map[Char, mutable.Buffer[CharRange]]()
      .withDefault(_ => mutable.Buffer[CharRange]())

    var i = 0
    while (i < s.length) {
      val char = s(i)
      val buffer = map(char)

      if (buffer.isEmpty || buffer.last.to != i) {
        buffer.append(CharRange(i, i + 1))
      } else {
        buffer.last.to = i + 1
      }

      i += 1
    }

    var max = 0
    var lastCovered = 0

    for ((_, buffer) <- map) {
      var i = 0
      while (i < buffer.length) {
        val range = buffer(i)

        var left = 0
        var right = 0

        if (lastCovered < range.from) {

        }

        if (lastCovered < range.to) {

        }

        max = Math.max(left + right + range.length, max)

        i += 1
      }
    }

    max
  }

  case class CharRange(from: Int, var to: Int) {

    def length: Int = to - from
  }

}
