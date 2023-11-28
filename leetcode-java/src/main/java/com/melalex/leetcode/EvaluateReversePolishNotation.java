package com.melalex.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

  public int evalRPN(String[] tokens) {
    var result = new Stack<Integer>();

    for (String token : tokens) {
      if ("+".equals(token)) {
        var right = result.pop();
        var left = result.pop();

        result.push(left + right);
      } else if ("-".equals(token)) {
        var right = result.pop();
        var left = result.pop();

        result.push(left - right);
      } else if ("*".equals(token)) {
        var right = result.pop();
        var left = result.pop();

        result.push(left * right);
      } else if ("/".equals(token)) {
        var right = result.pop();
        var left = result.pop();

        result.push(left / right);
      } else {
        result.push(Integer.parseInt(token));
      }
    }

    return result.pop();
  }

  public static void main(String[] args) {
    var app = new EvaluateReversePolishNotation();

    System.out.println("Should be 6: " + app.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
  }
}
