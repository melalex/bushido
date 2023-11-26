package com.melalex.leetcode;

import java.util.Stack;

class MinStack {

  private final Stack<Integer> stack = new Stack<>();
  private final Stack<Integer> mins = new Stack<>();

  public MinStack() {

  }

  public void push(int val) {
    if (mins.isEmpty() || val <= mins.peek()) {
      mins.push(val);
    } else {
      mins.push(mins.peek());
    }

    stack.push(val);
  }

  public void pop() {
    stack.pop();
    mins.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return mins.peek();
  }
}
