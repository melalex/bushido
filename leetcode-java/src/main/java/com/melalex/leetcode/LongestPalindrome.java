package com.melalex.leetcode;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindrome {

  public int longestPalindrome(String s) {
    long palindromeCount = 0;
    Map<Integer, Long> counts = s.chars()
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    boolean countedOdd = false;

    for (long value : counts.values()) {
      if (value > 1) {
        palindromeCount += value / 2 * 2;
      }
      if (!countedOdd && value % 2 == 1) {
        palindromeCount++;
        countedOdd = true;
      }
    }

    return (int) palindromeCount;
  }

  public static void main(String[] args) {
    final var longestPalindrome = new LongestPalindrome();

    System.out.println(longestPalindrome.longestPalindrome("ccc"));
  }
}
