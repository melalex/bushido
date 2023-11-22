package com.leetcode.dynamic

object WordLadder {

  def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
    val wordSet = wordList.toSet
    val visited = scala.collection.mutable.Set[String]()
    val queue = scala.collection.mutable.Queue[Word]()

    queue.enqueue(Word(beginWord, 1))

    while (queue.nonEmpty && queue.front.value != endWord) {
      val currWord = queue.dequeue()

      visited.addOne(currWord.value)

      for (i <- beginWord.indices) {
        for (ch <- 'a' to 'z') {
          val newWord = currWord.value.updated(i, ch)
          if (wordSet(newWord) && !visited(newWord)) {
            queue.enqueue(Word(newWord, currWord.number + 1))
          }
        }
      }
    }

    queue.headOption.map(_.number).getOrElse(0)
  }

  private case class Word(value: String, number: Int)

  def main(args: Array[String]): Unit = {
    println(s"Should be 5: ${ladderLength("hit", "cog", List("hot", "dot", "dog", "lot", "log", "cog"))}")
    println(s"Should be 0: ${ladderLength("hit", "cog", List("hot", "dot", "dog", "lot", "log"))}")
    println(s"Should be 10: ${ladderLength("ymain", "oecij", List("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"))}")
  }
}
