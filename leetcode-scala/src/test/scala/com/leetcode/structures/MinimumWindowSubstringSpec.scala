package com.leetcode.structures

import com.leetcode.TestSpec
import com.leetcode.structures.MinimumWindowSubstring.minWindow

class MinimumWindowSubstringSpec extends TestSpec {

  "MinimumWindowSubstring" when {
    "input 'ADOBECODEBANC' and 'ABC'" should {
      "return 'BANC'" in {
        minWindow("ADOBECODEBANC", "ABC") should be("BANC")
      }
    }
  }

  "MinimumWindowSubstring" when {
    "input 'a' and 'a'" should {
      "return 'a'" in {
        minWindow("a", "a") should be("a")
      }
    }
  }

  "MinimumWindowSubstring" when {
    "input 'a' and 'aa'" should {
      "return 'a'" in {
        minWindow("a", "aa") should be("")
      }
    }
  }

  "MinimumWindowSubstring" when {
    "input 'aa' and 'aa'" should {
      "return 'aa'" in {
        minWindow("aa", "aa") should be("aa")
      }
    }
  }
}
