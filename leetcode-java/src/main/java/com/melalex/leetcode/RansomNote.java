package com.melalex.leetcode;

public class RansomNote {

  public boolean canConstruct(String ransomNote, String magazine) {
    var dict = new int['z' - 'a' + 1];

    for (var i = 0; i < magazine.length(); i++) {
      dict[magazine.charAt(i) - 'a'] += 1;
    }

    for (var i = 0; i < ransomNote.length(); i++) {
      var dictIndex = ransomNote.charAt(i) - 'a';

      dict[dictIndex] -= 1;

      if (dict[dictIndex] < 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    var app = new RansomNote();
    System.out.println("Should be false: " + app.canConstruct("a", "b"));
    System.out.println("Should be false: " + app.canConstruct("az", "ab"));
    System.out.println("Should be false: " + app.canConstruct("aa", "ab"));
    System.out.println("Should be true: " + app.canConstruct("aa", "aab"));
  }
}
