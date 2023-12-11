package com.leetcode

object LetterCombinationsOfAPhoneNumber {

  def letterCombinations(digits: String): List[String] = {
    def loop(i: Int, acc: String): List[String] =
      if (i >= digits.length) List(acc)
      else digits(i) match {
        case '2' => loop(i + 1, acc + "a") ::: loop(i + 1, acc + "b") ::: loop(i + 1, acc + "c")
        case '3' => loop(i + 1, acc + "d") ::: loop(i + 1, acc + "e") ::: loop(i + 1, acc + "f")
        case '4' => loop(i + 1, acc + "g") ::: loop(i + 1, acc + "h") ::: loop(i + 1, acc + "i")
        case '5' => loop(i + 1, acc + "j") ::: loop(i + 1, acc + "k") ::: loop(i + 1, acc + "l")
        case '6' => loop(i + 1, acc + "m") ::: loop(i + 1, acc + "n") ::: loop(i + 1, acc + "o")
        case '7' => loop(i + 1, acc + "p") ::: loop(i + 1, acc + "q") ::: loop(i + 1, acc + "r") ::: loop(i + 1, acc + "s")
        case '8' => loop(i + 1, acc + "t") ::: loop(i + 1, acc + "u") ::: loop(i + 1, acc + "v")
        case '9' => loop(i + 1, acc + "w") ::: loop(i + 1, acc + "x") ::: loop(i + 1, acc + "y") ::: loop(i + 1, acc + "z")
      }

    if (digits.isEmpty) Nil
    else loop(0, "")
  }
}
