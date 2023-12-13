package com.leetcode

object WordSearch {

  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val m = board.length
    val n = board(0).length

    def loop(pos: (Int, Int), visited: Set[(Int, Int)], wordIndex: Int): Boolean = {
      val (i, j) = pos
      if (wordIndex >= word.length) true
      else if (i >= m || j >= n || i < 0 || j < 0 || visited(pos) || board(i)(j) != word(wordIndex)) false
      else {
        val newVisited = visited + pos
        val newIndex = wordIndex + 1
        loop((i + 1, j), newVisited, newIndex) || loop((i, j + 1), newVisited, newIndex) || loop((i - 1, j), newVisited, newIndex) || loop((i, j - 1), newVisited, newIndex)
      }
    }

    val indices = for (i <- board.indices; j <- board(i).indices) yield i -> j

    indices.exists(it => loop(it, Set.empty, 0))
  }
}
