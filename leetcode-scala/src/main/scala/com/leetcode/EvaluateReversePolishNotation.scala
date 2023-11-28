package com.leetcode

object EvaluateReversePolishNotation {

  def evalRPN(tokens: Array[String]): Int = {
eval(parse(tokens))
  }

  private def parse(tokens: Array[String]) = {
    def loop(i: Int) = {
      val token = tokens(i)

      if ("+" == token) Plus(loop(i))
      else if ("-" == token) result -= tokens(i - 1).toInt
      else if ("*" == token) result *= tokens(i - 1).toInt
      else if ("/" == token) result /= tokens(i - 1).toInt
      else Literal(token.toInt)
    }

  }

  private def eval(exp: Exp): Int = exp match {
    case Literal(value) => value
    case Plus(left, right) => eval(left) + eval(right)
    case Minus(left, right) => eval(left) - eval(right)
    case Multiply(left, right) => eval(left) * eval(right)
    case Divide(left, right) => eval(left) / eval(right)
  }

  private sealed trait Exp

  private case class Literal(value: Int) extends Exp

  private case class Plus(left: Exp, right: Exp) extends Exp

  private case class Minus(left: Exp, right: Exp) extends Exp

  private case class Multiply(left: Exp, right: Exp) extends Exp

  private case class Divide(left: Exp, right: Exp) extends Exp
}
