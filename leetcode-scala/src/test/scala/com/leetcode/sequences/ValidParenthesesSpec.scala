package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.sequences.ValidParentheses.isValid

class ValidParenthesesSpec extends TestSpec {

  "ValidParentheses" when {
    "input is: ()" should {
      "return true" in {
        isValid("()") should be(true)
      }
    }

    "input is: ()[]{}" should {
      "return true" in {
        isValid("()[]{}") should be(true)
      }
    }

    "input is: (]" should {
      "return false" in {
        isValid("(]") should be(false)
      }
    }

    "input is: ([)]" should {
      "return false" in {
        isValid("([)]") should be(false)
      }
    }

    "input is: }{" should {
      "return false" in {
        isValid("}{") should be(false)
      }
    }

    "input is: {[]}" should {
      "return true" in {
        isValid("{[]}") should be(true)
      }
    }
  }
}
