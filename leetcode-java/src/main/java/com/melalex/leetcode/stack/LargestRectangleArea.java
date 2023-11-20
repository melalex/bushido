package com.melalex.leetcode.stack;

import java.util.Stack;

public class LargestRectangleArea {

  public int largestRectangleArea(int[] heights) {
    var stack = new Stack<Integer>();
    var length = heights.length;
    var maxArea = 0;

    for (var i = 0; i < length; i++) {
      while (!offerMonotonic(stack, heights, i)) {
        maxArea = Math.max(maxArea, calculateAreaForHead(stack, heights, i));
      }
    }

    while (!stack.isEmpty()) {
      maxArea = Math.max(maxArea, calculateAreaForHead(stack, heights, length));
    }

    return maxArea;
  }

  private int calculateAreaForHead(Stack<Integer> target, int[] heights, int maxLen) {
    var head = target.pop();
    var prev = peekSafe(target);

    return (maxLen - prev - 1) * heights[head];
  }

  private boolean offerMonotonic(Stack<Integer> target, int[] heights, int index) {
    if (target.isEmpty() || heights[target.peek()] < heights[index]) {
      target.push(index);
      return true;
    } else {
      return false;
    }
  }

  private int peekSafe(Stack<Integer> target) {
    if (target.isEmpty()) return -1;
    else return target.peek();
  }

  public static void main(String[] args) {
    var app = new LargestRectangleArea();

    System.out.println("Should be 10: " + app.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    System.out.println("Should be 4: " + app.largestRectangleArea(new int[]{2, 4}));
    System.out.println("Should be 1: " + app.largestRectangleArea(new int[]{0, 1, 0, 1}));
    System.out.println("Should be 25: " + app.largestRectangleArea(new int[]{2, 2, 6, 6, 5, 5, 5, 0, 9, 3, 6, 3, 8, 6, 6}));
  }
}
