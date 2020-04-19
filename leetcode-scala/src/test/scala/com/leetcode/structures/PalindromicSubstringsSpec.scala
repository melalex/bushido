package com.leetcode.structures

import com.leetcode.TestSpec
import com.leetcode.structures.PalindromicSubstrings.countSubstrings

class PalindromicSubstringsSpec extends TestSpec {

  "PalindromicSubstrings" when {
    "input 'abc'" should {
      "return 3" in {
        countSubstrings("abc") should be(3)
      }
    }

    "input 'aaa'" should {
      "return 6" in {
        countSubstrings("aaa") should be(6)
      }
    }

    "input 'xkjkqlajprjwefilxgpdpebieswu'" should {
      "return 30" in {
        countSubstrings("xkjkqlajprjwefilxgpdpebieswu") should be(30)
      }
    }
  }
}
