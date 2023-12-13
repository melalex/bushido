package com.melalex.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {

  public List<Integer> findAnagrams(String s, String p) {
    if (s.length() < p.length()) {
      return List.of();
    }

    var lettersCount = 'z' - 'a' + 1;
    var target = new int[lettersCount];
    var current = new int[lettersCount];
    var result = new ArrayList<Integer>();

    for (int i = 0; i < p.length(); i++) {
      target[p.charAt(i) - 'a']++;
      current[s.charAt(i) - 'a']++;
    }

    if (Arrays.equals(target, current)) {
      result.add(0);
    }

    for (int i = p.length(); i < s.length(); i++) {
      var first = s.charAt(i - p.length()) - 'a';
      var last = s.charAt(i) - 'a';

      current[first]--;
      current[last]++;

      if (Arrays.equals(target, current)) {
        result.add(i - p.length() + 1);
      }
    }

    return result;
  }
}
