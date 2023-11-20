package com.melalex.leetcode.stack;

import java.util.Stack;

public class LargestRectangleArea {

  private static final HeightAndIndex ZERO = new HeightAndIndex(-1, -1);

  public int largestRectangleArea(int[] heights) {
    var stack = new Stack<HeightAndIndex>();
    var length = heights.length;
    var maxArea = 0;

    for (var i = 0; i < length; i++) {
      var heightAndIndex = new HeightAndIndex(heights[i], i);

      while (!offerMonotonic(stack, heightAndIndex)) {
        maxArea = Math.max(maxArea, calculateAreaForHead(stack, i));
      }
    }

    while (!stack.isEmpty()) {
      maxArea = Math.max(maxArea, calculateAreaForHead(stack, length));
    }

    return maxArea;
  }

  private int calculateAreaForHead(Stack<HeightAndIndex> target, int maxLen) {
    var head = target.pop();
    var prev = peekSafe(target);

    System.out.println("Calculate area: " + head + ". Start - " + (prev.index + 1) + ", end - " + maxLen + ", area - " + (maxLen - prev.index - 1) * head.height);

    return (maxLen - prev.index - 1) * head.height;
  }

  private boolean offerMonotonic(Stack<HeightAndIndex> target, HeightAndIndex element) {
    if (target.isEmpty() || target.peek().height < element.height) {
      target.push(element);
      return true;
    } else {
      return false;
    }
  }

  private HeightAndIndex peekSafe(Stack<HeightAndIndex> target) {
    if (target.isEmpty()) return ZERO;
    else return target.peek();
  }

  private HeightAndIndex popSafe(Stack<HeightAndIndex> target) {
    if (target.isEmpty()) return ZERO;
    else return target.pop();
  }

  public record HeightAndIndex(int height, int index) {

  }

  public static void main(String[] args) {
    var app = new LargestRectangleArea();

    System.out.println("Should be 10: " + app.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    System.out.println("Should be 4: " + app.largestRectangleArea(new int[]{2, 4}));
    System.out.println("Should be 1: " + app.largestRectangleArea(new int[]{0, 1, 0, 1}));
    System.out.println("Should be 25: " + app.largestRectangleArea(new int[]{2, 2, 6, 6, 5, 5, 5, 0, 9, 3, 6, 3, 8, 6, 6}));
  }
}
