package com.melalex.leetcode;

public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    var result = "";

    for (var i = 0; i < s.length(); i++) {
      var odd = seekPalindrome(s, i, i);
      var even = seekPalindrome(s, i, i + 1);

      if (odd.length() > result.length()) {
        result = odd;
      }

      if (even.length() > result.length()) {
        result = even;
      }
    }

    return result;
  }

  private String seekPalindrome(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return s.substring(left + 1, right);
  }
}
