package com.leetcode.advanced

import com.leetcode.TestSpec

class TrieSpec extends TestSpec {

  "TrieSpec" when {
    "smoke test" should {
      "return expected result" in {
        val trie = new Trie

        trie.insert("apple")
        trie.search("apple") should be(true)

        trie.search("app") should be(false)

        trie.startsWith("app") should be(true)

        trie.insert("app")

        trie.search("app") should be(true)
      }
    }
  }
}
