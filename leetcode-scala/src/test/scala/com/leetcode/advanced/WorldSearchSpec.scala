package com.leetcode.advanced

import com.leetcode.TestSpec
import com.leetcode.advanced.WorldSearch.findWords

class WorldSearchSpec extends TestSpec {

  "WorldSearch" when {
    "regular input" should {
      "return expected result" in {
        val words = Array("oath", "pea", "eat", "rain")
        val board = Array(
          Array('o', 'a', 'a', 'n'),
          Array('e', 't', 'a', 'e'),
          Array('i', 'h', 'k', 'r'),
          Array('i', 'f', 'l', 'v')
        )

        findWords(board, words).toSet should be(Set("eat", "oath"))
      }
    }

    "input with duplicates" should {
      "return expected result" in {
        val words = Array("a")
        val board = Array(Array('a', 'a'))

        findWords(board, words) should be(List("a"))
      }
    }

    "input [[\"a\",\"b\"],[\"c\",\"d\"]]; [\"ab\",\"cb\",\"ad\",\"bd\",\"ac\",\"ca\",\"da\",\"bc\",\"db\",\"adcb\",\"dabc\",\"abb\",\"acb\"]" should {
      "return [\"ab\",\"ac\",\"bd\",\"ca\",\"db\"]" in {
        val words = Array("ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb")
        val board = Array(Array('a', 'b'), Array('c', 'd'))

        findWords(board, words).toSet should be(Set("ab", "ac", "bd", "ca", "db"))
      }
    }
  }
}
