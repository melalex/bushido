package com.melalex.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

  public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] result = new int[nums.length - k + 1];

    for (int i = 0; i < nums.length; i++) {
      while (!deque.isEmpty() && (nums[deque.peekFirst()] < nums[i] || deque.peekFirst() <= i - k)) deque.removeFirst();

      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();

      deque.addLast(i);

      if (i >= k - 1) {
        result[i - k + 1] = nums[deque.peek()];
      }
    }

    return result;
  }

  public static void main(String[] args) {
    final var slidingWindowMaximum = new SlidingWindowMaximum();

    System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
//    System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//    System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1}, 1)));
//    System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(new int[]{1, -1}, 1)));
  }
}
