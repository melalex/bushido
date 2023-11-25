package com.melalex.leetcode;

import java.util.Stack;

public class ImplementQueueUsingStacks {

  static class MyQueue {

    private final Stack<Integer> write = new Stack<>();
    private final Stack<Integer> read = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
      write.push(x);
    }

    public int pop() {
      transferFromWriteToRead();

      return read.pop();
    }

    public int peek() {
      transferFromWriteToRead();

      return read.peek();
    }

    public boolean empty() {
      return write.isEmpty() && read.isEmpty();
    }

    private void transferFromWriteToRead() {
      if (read.isEmpty()) {

        while (!write.isEmpty()) {
          read.push(write.pop());
        }
      }
    }
  }
}
