package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.ValidAnagram.isAnagram

class ValidAnagramSpec extends TestSpec {

  "Valid anagram" when {
    "input: s = \"anagram\", t = \"nagaram\"" should {
      "return true" in {
        isAnagram("anagram", "nagaram") should be(true)
      }
    }

    "input: s = \"rat\", t = \"car\"" should {
      "return false" in {
        isAnagram("rat", "car") should be(false)
      }
    }
  }
}
