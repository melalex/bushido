package com.melalex.leetcode;

import java.util.PriorityQueue;

public class StoneGame4 {

  public int stoneGameVI(int[] aliceValues, int[] bobValues) {
    int stoneCount = aliceValues.length;
    int alicePoints = 0;
    int bobPoints = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

    for (int i = 0; i < stoneCount; i++) {
      pq.add(new int[]{i, aliceValues[i] + bobValues[i]});
    }

    boolean isAliceTurn = true;

    while (!pq.isEmpty()) {
      int i = pq.poll()[0];

      if (isAliceTurn) {
        alicePoints += aliceValues[i];
      } else {
        bobPoints += bobValues[i];
      }

      isAliceTurn = !isAliceTurn;
    }

    return Integer.compare(alicePoints, bobPoints);
  }

  public static void main(String[] args) {
    final var stoneGame4 = new StoneGame4();

    System.out.println(stoneGame4.stoneGameVI(new int[]{9, 8, 3, 8}, new int[]{10, 6, 9, 5}));
  }
}
