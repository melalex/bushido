package com.leetcode.dynamic

import com.leetcode.TestSpec
import com.leetcode.WordBreak.wordBreak

class WordBreakSpec extends TestSpec {

  "WordBreak" when {
    "s = \"leetcode\", wordDict = [\"leet\", \"code\"]" should {
      "return true" in {
        wordBreak("leetcode", List("leet", "code")) should be(true)
      }
    }

    "s = \"applepenapple\", wordDict = [\"apple\", \"pen\"]" should {
      "return true" in {
        wordBreak("applepenapple", List("apple", "pen")) should be(true)
      }
    }

    "s = \"catsandog\", wordDict = [\"cats\", \"dog\", \"sand\", \"and\", \"cat\"]" should {
      "return false" in {
        wordBreak("catsandog", List("cats", "dog", "sand", "and", "cat")) should be(false)
      }
    }

    "s = \"aaaaaaa\", wordDict = [\"aaaa\",\"aa\"]" should {
      "return false" in {
        wordBreak("aaaaaaa", List("aaaa", "aa")) should be(false)
      }
    }

    "s = \"aaaaaaa\", wordDict = [\"aaaa\",\"aaa\"]" should {
      "return true" in {
        wordBreak("aaaaaaa", List("aaaa", "aaa")) should be(true)
      }
    }

    "s = \"abcde\", wordDict = [\"abc\",\"de\",\"abcd\"]" should {
      "return true" in {
        wordBreak("abcde", List("abc","de","abcd")) should be(true)
      }
    }

    "s = \"abcde\", wordDict = [\"abc\",\"e\",\"abcd\"]" should {
      "return true" in {
        wordBreak("aaaaaaa", List("aaaa", "aaa")) should be(true)
      }
    }
  }
}
