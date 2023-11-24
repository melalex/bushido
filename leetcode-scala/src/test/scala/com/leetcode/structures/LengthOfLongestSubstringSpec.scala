package com.leetcode.structures

import com.leetcode.TestSpec
import com.leetcode.LengthOfLongestSubstring.lengthOfLongestSubstring

class LengthOfLongestSubstringSpec extends TestSpec {

  "LengthOfLongestSubstring" when {
    "input 'abcabcbb'" should {
      "return 3" in {
        lengthOfLongestSubstring("abcabcbb") should be(3)
      }
    }
  }

  "LengthOfLongestSubstring" when {
    "input 'bbbbb'" should {
      "return 1" in {
        lengthOfLongestSubstring("bbbbb") should be(1)
      }
    }
  }

  "LengthOfLongestSubstring" when {
    "input 'pwwkew'" should {
      "return 3" in {
        lengthOfLongestSubstring("pwwkew") should be(3)
      }
    }
  }
}
