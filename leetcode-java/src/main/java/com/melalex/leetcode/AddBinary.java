package com.melalex.leetcode;

public class AddBinary {

  public String addBinary(String a, String b) {
    if (a.length() < b.length()) {
      var buff = a;

      a = b;
      b = buff;
    }

    var result = new char[a.length()];
    var remaining = '0';

    for (var i = a.length() - 1; i >= 0; i--) {
      var j = i - (a.length() - b.length());

      var sum = intAt(a, i) + intAt(b, j) + asInt(remaining);

      if (sum == 0) {
        result[i] = '0';
        remaining = '0';
      } else if (sum == 1) {
        result[i] = '1';
        remaining = '0';
      } else if (sum == 2) {
        result[i] = '0';
        remaining = '1';
      } else {
        result[i] = '1';
        remaining = '1';
      }
    }

    var resultStr = new StringBuilder(a.length() + 1);

    if (remaining == '1') {
      resultStr.append(remaining);
    }

    resultStr.append(result);

    return resultStr.toString();
  }

  private int intAt(String str, int i) {
    if (i < 0) return 0;
    else return asInt(str.charAt(i));
  }

  private int asInt(char ch) {
    return ch - '0';
  }
}
