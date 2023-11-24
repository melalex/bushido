package com.leetcode

class Trie {

  private val children = Array.fill[Option[Trie]](26)(Option.empty)
  private var last = false

  def insert(word: String): Unit =
    if (word.isEmpty) last = true
    else getOrCreateChild(word.head).insert(word.drop(1))

  def search(word: String): Boolean = innerSearch(word, t => t.last)

  def startsWith(prefix: String): Boolean = innerSearch(prefix, _ => true)

  @scala.annotation.tailrec
  private def innerSearch(word: String, result: Trie => Boolean): Boolean =
    if (word.isEmpty) result(this)
    else getChild(word.head) match {
      case Some(value) => value.innerSearch(word.drop(1), result)
      case None => false
    }

  private def getOrCreateChild(char: Char): Trie = getChild(char) match {
    case Some(value) => value
    case None => setChild(char, new Trie)
  }

  private def getChild(char: Char): Option[Trie] = children(index(char))

  private def setChild(char: Char, trie: Trie): Trie = {
    children(index(char)) = Some(trie)
    trie
  }

  private def index(char: Char) = char - 'a'
}
