package com.melalex.leetcode.greedy;

import java.util.BitSet;

public class JumpGame7 {

  public boolean canReach(String s, int minJump, int maxJump) {
    if (s.charAt(s.length() - 1) == '1') {
      return false;
    }

    BitSet canVisit = new BitSet();
    int max = 0;
    canVisit.set(0);

    for (int i = 0; i < s.length(); i++) {
      if (canVisit.get(i)) {
        int limit = Math.min(i + maxJump, s.length() - 1);

        for (int j = Math.max(i + minJump, max); j <= limit; j++) {
          canVisit.set(j, s.charAt(j) == '0');
        }

        max = limit;
      }
    }

    return canVisit.get(s.length() - 1);
  }
}
