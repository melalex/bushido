package com.melalex.leetcode;

public class StringToInteger {
  private static final int[] POWERS_OF_TEN = {
      1,
      10,
      100,
      1_000,
      10_000,
      100_000,
      1_000_000,
      10_000_000,
      100_000_000,
      1_000_000_000
  };

  public int myAtoi(String s) {
    var from = 0;

    while (from < s.length() && s.charAt(from) == ' ') {
      from++;
    }

    var isNegative = false;

    if (from < s.length() && s.charAt(from) == '-') {
      isNegative=true;
      from++;
    } else if (from < s.length() && s.charAt(from) == '+') {
      from++;
    }

    while (from < s.length() && s.charAt(from) == '0') {
      from++;
    }

    var to = from;

    while (to < s.length() && s.charAt(to) >= '0' && s.charAt(to) <= '9') {
      to++;
    }

    if (to - from > 10 || (to - from == 10 && s.charAt(from) - '0' > 2)) {
      if (isNegative) return Integer.MIN_VALUE;
      else return Integer.MAX_VALUE;
    }

    var acc = 0;

    for (var i = to - 1; i >= from; i--) {
      acc += (s.charAt(i) - '0') * POWERS_OF_TEN[to - 1 - i];
    }

    if (acc < 0) {
      if (isNegative) return Integer.MIN_VALUE;
      else return Integer.MAX_VALUE;
    } else {
      if (isNegative) return -acc;
      else return acc;
    }
  }

  public static void main(String[] args) {
    var app = new StringToInteger();

    System.out.println(app.myAtoi("21474836460"));
  }
}
