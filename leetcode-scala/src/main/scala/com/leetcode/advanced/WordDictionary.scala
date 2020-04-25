package com.leetcode.advanced

class WordDictionary {

  private val root = new WordTree()

  def addWord(word: String): Unit = {
    val length = word.length

    @scala.annotation.tailrec
    def inner(i: Int, dictionary: WordTree): Unit =
      if (i >= length) dictionary.last = true
      else inner(i + 1, dictionary.getOrCreateChild(word(i)))

    inner(0, root)
  }

  def search(word: String): Boolean = {
    val length = word.length

    def inner(i: Int, dictionary: WordTree): Boolean =
      if (i >= length) dictionary.last
      else if (word(i) == '.') dictionary.words(length).exists(w => inner(i + 1, w))
      else {
        val next = dictionary.getChild(word(i))

        next != null && inner(i + 1, next)
      }

    inner(0, root)
  }

  private class WordTree {
    val letters = new Array[WordTree](26)
    var last = false

    def getOrCreateChild(char: Char): WordTree = {
      val i = index(char)

      if (letters(i) == null) {
        letters(i) = new WordTree()
      }

      letters(i)
    }

    def getChild(char: Char): WordTree = letters(index(char))

    def words(size: Int): Seq[WordTree] = LazyList(letters: _*).filterNot(_ == null)

    private def index(char: Char) = char - 'a'
  }

}

