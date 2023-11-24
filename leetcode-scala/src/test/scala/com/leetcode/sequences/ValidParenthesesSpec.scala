package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.ValidParentheses.isValid

class ValidParenthesesSpec extends TestSpec {

  "ValidParentheses" when {
    "input is: ()" should {
      "return true" in {
        isValid("()") should be(true)
      }
    }

    "input is: ()qwe" should {
      "return true" in {
        isValid("()qwe") should be(true)
      }
    }

    "input is: ()(" should {
      "return false" in {
        isValid("()(") should be(false)
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

    "input empty string" should {
      "return true" in {
        isValid("") should be(true)
      }
    }

    "input without parentheses" should {
      "return true" in {
        isValid("qweqwe") should be(true)
      }
    }
  }
}
