package com.leetcode.advanced

import com.leetcode.TestSpec

class WordDictionarySpec extends TestSpec {

  "WordDictionary" when {
    "smoke test" should {
      "return expected result" in {
        val dictionary = new WordDictionary()

        dictionary.addWord("bad")
        dictionary.addWord("dad")
        dictionary.addWord("mad")

        dictionary.search("pad") should be(false)
        dictionary.search("bad") should be(true)
        dictionary.search(".ad") should be(true)
        dictionary.search("b..") should be(true)
      }
    }

    "add between searches" should {
      "return expected result" in {
        val dictionary = new WordDictionary()

        dictionary.addWord("at")
        dictionary.addWord("and")
        dictionary.addWord("an")
        dictionary.addWord("add")

        dictionary.search("a") should be(false)
        dictionary.search(".at") should be(false)

        dictionary.addWord("bat")

        dictionary.search(".at") should be(true)
        dictionary.search("an.") should be(true)
        dictionary.search("a.d.") should be(false)
        dictionary.search("b.") should be(false)
        dictionary.search("a.d") should be(true)
        dictionary.search(".") should be(false)
      }
    }
  }
}
