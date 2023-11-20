package com.melalex.leetcode.stack;

import java.util.Stack;

public class LargestRectangleArea {

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
            maxArea = Math.max(maxArea, calculateAreaForHead(stack, length - 1));
        }

        return maxArea;
    }

    private int calculateAreaForHead(Stack<HeightAndIndex> target, int maxLen) {
        var head = target.pop();

        return (maxLen - peekIndexSafe(target) - 1) * head.height;
    }

    private boolean offerMonotonic(Stack<HeightAndIndex> target, HeightAndIndex element) {
        if (target.isEmpty()) {
            target.push(element);
            return true;
        } else if (target.peek().height == element.height) {
            return true;
        } else if (target.peek().height < element.height) {
            target.push(element);
            return true;
        } else {
            return false;
        }
    }

    private int peekIndexSafe(Stack<HeightAndIndex> target) {
        if (target.isEmpty()) return -1;
        else return target.peek().index;
    }

    public static record HeightAndIndex(int height, int index) {

    }

    public static void main(String[] args) {
        var app = new LargestRectangleArea();

        var input = new int[]{2, 1, 5, 6, 2, 3};

        System.out.println(app.largestRectangleArea(input));
    }
}
