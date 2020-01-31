package com.leetcode.sequences

object ValidParentheses {

  private val parenthesis: Map[Char, Char] = Map(
    '(' -> ')',
    '{' -> '}',
    '[' -> ']'
  )

  private val openedParenthesis: Set[Char] = parenthesis.keySet
  private val closedParenthesis: Set[Char] = parenthesis.values.toSet

  def isValid(string: String): Boolean = {
    def iteration(iterator: Iterator[Char], target: Char): Boolean = {
      while (iterator.hasNext) {
        val char = iterator.next

        if (openedParenthesis(char)) return iteration(iterator, parenthesis(char))
        else if (closedParenthesis(char)) return false
        else if (char == target) return true
      }

      false
    }

    iteration(string.iterator, 't')
  }
}
