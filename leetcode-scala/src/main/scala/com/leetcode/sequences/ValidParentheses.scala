package com.leetcode.sequences

object ValidParentheses {

  private val parenthesis: Map[Char, Char] = Map(
    '(' -> ')',
    '{' -> '}',
    '[' -> ']'
  )

  private val openedParenthesis: Set[Char] = parenthesis.keySet
  private val closedParenthesis: Set[Char] = parenthesis.values.toSet

  private val EOF = '\u0000'

  def isValid(string: String): Boolean = {
    var stack = EOF :: Nil

    for (char <- string) {
      if (stack.head == char) stack = stack.tail
      else if (openedParenthesis(char)) stack = parenthesis(char) :: stack
      else if (closedParenthesis(char)) return false
    }

    stack.head == EOF
  }
}
