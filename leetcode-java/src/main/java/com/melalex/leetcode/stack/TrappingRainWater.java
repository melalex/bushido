package com.melalex.leetcode.stack;

public class TrappingRainWater {

  public int trap(int[] height) {
    var left = 1;
    var right = height.length - 2;
    var maxLeft = height[0];
    var maxRight = height[height.length - 1];
    var value = 0;

    while (left <= right) {
      if (maxLeft < maxRight) {
        var currentHeight = height[left];

        value += Math.max(maxLeft - currentHeight, 0);
        maxLeft = Math.max(currentHeight, maxLeft);

        left++;
      } else {
        var currentHeight = height[right];

        value += Math.max(maxRight - currentHeight, 0);
        maxRight = Math.max(currentHeight, maxRight);

        right--;
      }
    }

    return value;
  }

  public static void main(String[] args) {
    var app = new TrappingRainWater();

    System.out.println("Should be 1: " + app.trap(new int[]{4, 2, 3}));
    System.out.println("Should be 6: " + app.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    System.out.println("Should be 9: " + app.trap(new int[]{4, 2, 0, 3, 2, 5}));
    System.out.println("Should be 0: " + app.trap(new int[]{0, 1, 2, 3, 4, 5}));
    System.out.println("Should be 0: " + app.trap(new int[]{5, 4, 3, 2, 1, 0}));
  }


  //    var descStack = new java.util.Stack<Integer>();
//    var volume = 0;
//
//    for (var i = 0; i < height.length; i++) {
//      if (!descStack.isEmpty() && height[descStack.peek()] < height[i]) {
//        var leftBound = descStack.peek();
//        var lastRightBound = leftBound;
//        var minHeight = height[lastRightBound];
//
//        while (!descStack.isEmpty() && height[leftBound] <= height[i]) {
//          descStack.pop();
//          if (!descStack.isEmpty()) {
//            leftBound = descStack.peek();
//          }
//        }
//
//        var maxHeight = Math.min(height[leftBound], height[i]);
//
//        for (var j = leftBound + 1; j < lastRightBound; j++) {
//          var addVolume = maxHeight - Math.max(minHeight, height[j]);
//
//          volume += addVolume;
//        }
//
//        for (var j = lastRightBound; j < i; j++) {
//          var addVolume = maxHeight - height[j];
//
//          volume += addVolume;
//        }
//      }
//
//      descStack.push(i);
//    }
//
//    return volume;


  //    var ascStack = new java.util.Stack<Integer>();
//    var i = 0;
//    while (i < height.length) {
//      if (!descStack.isEmpty() && descStack.peek() < height[i]) {
//
//        while (i < height.length && ascStack.peek() <= height[i]) {
//          ascStack.push(height[i]);
//          i++;
//        }
//
//        while (!ascStack.isEmpty()) {
//
//        }
//
//      } else {
//        descStack.push(height[i]);
//      }
//
//      i++;
//    }
//
//
//    while (i < height.length) {
//      if (!descStack.isEmpty() && descStack.peek() < height[i]) {
//
//        while (i < height.length && ascStack.peek() <= height[i]) {
//          ascStack.push(height[i]);
//          i++;
//        }
//
//        while (!ascStack.isEmpty()) {
//
//        }
//
//      } else {
//        descStack.push(height[i]);
//      }
//
//      i++;
//    }

}
