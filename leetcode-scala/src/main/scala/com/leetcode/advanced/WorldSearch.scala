package com.leetcode.advanced

object WorldSearch {

  def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {

    def dfs(i: Int, j: Int, node: Node, visited: Set[(Int, Int)]): List[String] =
      find(i + 1, j, node, visited) :::
        find(i - 1, j, node, visited) :::
        find(i, j + 1, node, visited) :::
        find(i, j - 1, node, visited)

    def find(i: Int, j: Int, trie: Node, visited: Set[(Int, Int)]): List[String] =
      if (i < 0 || i >= board.length || j < 0 || j >= board(i).length || visited((i, j))) Nil
      else trie(board(i)(j)) match {
        case Leaf => Nil
        case node: Word => node.word :: dfs(i, j, node, visited + ((i, j)))
        case node: Node => dfs(i, j, node, visited + ((i, j)))
      }

    val trie = Trie(words)
    var result = List[String]()

    for {
      i <- board.indices
      j <- board(i).indices
    } {
      result = find(i, j, trie, Set()) ::: result
    }

    result.distinct
  }

  object Trie {

    def apply(words: Array[String]): Node = {
      val result = Node()

      for (word <- words) {
        add(result, word)
      }

      result
    }

    @scala.annotation.tailrec
    def add(target: Node, word: String, pos: Int = 0): Unit =
      if (pos == word.length - 1) target.withWordChild(word(pos), word)
      else add(target.withNodeChild(word(pos)), word, pos + 1)
  }

  trait Trie {

    def children: Array[Trie]
  }

  object Leaf extends Trie {

    override def children: Array[Trie] = Array.fill(26)(Leaf)
  }

  case class Node(children: Array[Trie] = Array.fill(26)(Leaf)) extends Trie {

    def apply(char: Char): Trie = children(index(char))

    def withNodeChild(char: Char): Node = {
      val i = index(char)
      val trie = children(i)

      trie match {
        case Leaf =>
          val node = Node()
          children(i) = node
          node
        case node: Node => node
      }
    }

    def withWordChild(char: Char, word: String): Word = {
      val i = index(char)
      val oldNode = children(i)
      val newNode = new Word(word, oldNode.children)

      children(i) = newNode

      newNode
    }

    private def index(ch: Char) = ch - 'a'
  }

  class Word(val word: String, tries: Array[Trie]) extends Node(tries)

}
