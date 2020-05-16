package com.leetcode.dynamic

object WordBreak {

  def wordBreak(s: String, wordDict: List[String]): Boolean = {
    val trie = Trie(wordDict)
    val visited = collection.mutable.Set[Int]()

    def visit(i: Int): Int = {
      visited += i
      i
    }

    def iter(i: Int, runner: Node): Boolean =
      if (i == s.length) runner.last
      else runner(s(i)) match {
        case Leaf => false
        case node: Node if node.last =>  iter(i + 1, node) || !visited(i + 1) && iter(visit(i + 1), trie)
        case node: Node => iter(i + 1, node)
      }

    iter(0, trie)
  }

  object Trie {

    def apply(words: List[String]): Node = {
      val result = Node()

      for (word <- words) {
        add(result, word)
      }

      result
    }

    @scala.annotation.tailrec
    def add(target: Node, word: String, pos: Int = 0): Unit =
      if (pos == word.length - 1) target.withWordChild(word(pos))
      else add(target.withNodeChild(word(pos)), word, pos + 1)
  }

  trait Trie

  object Leaf extends Trie

  case class Node(var last: Boolean = false) extends Trie {

    private val children: Array[Trie] = Array.fill(26)(Leaf)

    def apply(char: Char): Trie = children(index(char))

    def withNodeChild(char: Char): Node = withChild(char, last = false)

    def withWordChild(char: Char): Node = withChild(char, last = true)

    private def withChild(char: Char, last: Boolean): Node = {
      val i = index(char)

      children(i) match {
        case Leaf =>
          val node = Node(last)
          children(i) = node
          node
        case node: Node => {
          node.last ||= last
          node
        }
      }
    }

    private def index(ch: Char) = ch - 'a'
  }

}
