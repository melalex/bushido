package com.leetcode.greedy

object RemoveKDigits {

  def removeKdigits(num: String, k: Int): String = {
    val numLen = num.length

    if (numLen - k <= 0) {
      return "0"
    }

    def getDigit(i: Int): Char =
      if (i >= numLen) '/'
      else num(i)

    var builder = List[Char]()
    var needToRemove = k

    for (i <- 0 to numLen) {
      //      println(s"res = ${builder.mkString} i = $i")

      while (builder.headOption.getOrElse('/') > getDigit(i) && needToRemove > 0) {
        needToRemove -= 1
        builder = builder.tail
      }

      if (i < numLen) {
        builder = num(i) :: builder
      }
    }

    val result = builder.reverse.dropWhile(_ == '0')

    if (result.isEmpty) "0" else result.mkString("")
  }

  def main(args: Array[String]): Unit = {
    assert(removeKdigits("1432219", 3) == "1219")
    assert(removeKdigits("10200", 1) == "200")
    assert(removeKdigits("10", 2) == "0")
    assert(removeKdigits("10", 1) == "0")
    assert(removeKdigits("12239", 2) == "122")
    assert(removeKdigits("5337", 2) == "33")
    assert(removeKdigits("1234567890", 9) == "0")
    assert(removeKdigits("9999999999991", 8) == "99991")
  }
}
