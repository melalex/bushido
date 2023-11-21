package com.leetcode.advanced

object BasicCalculator {

  private val Zero = NumberExpression(0)

  def calculate(s: String): Int = {
    val expression = parse(s)
    eval(expression)
  }

  private def parse(source: String): Expression = {
    def parseInternal(i: Int, acc: Expression): (Int, Expression) = {
      if (i >= source.length) (i, acc)
      else if (source(i) == ')') (i + 1, acc)
      else if (source(i) == ' ') parseInternal(i + 1, acc)
      else if (source(i) == '+') {
        val (next, res) = parseInternal(i + 1, Zero)

        parseInternal(next, PlusExpression(acc, res))
      } else if (source(i) == '-') {
        val (next, res) = parseInternal(i + 1, Zero)

        parseInternal(next, MinusExpression(acc, res))
      } else if (source(i) == '(') {
        var next = i + 1
        var currExp: Expression = Zero

        do {
          val (nextNext, nextCurrExp) = parseInternal(next, currExp)

          next = nextNext
          currExp = nextCurrExp
        } while (source(next - 1) != ')')

        (next, currExp)
      } else {
        var j = i

        while (j < source.length && source(j).isDigit) {
          j += 1
        }

        (j, NumberExpression(source.substring(i, j).toInt))
      }
    }

    var i = 0
    var exp: Expression = Zero

    while (i < source.length) {
      val (next, currExp) = parseInternal(i, exp)
      i = next
      exp = currExp
    }

    exp
  }

  private def eval(node: Expression): Int = node match {
    case NumberExpression(value) => value
    case PlusExpression(left, right) => eval(left) + eval(right)
    case MinusExpression(left, right) => eval(left) - eval(right)
  }

  private sealed trait Expression

  private case class NumberExpression(value: Int) extends Expression

  private case class PlusExpression(left: Expression, right: Expression) extends Expression

  private case class MinusExpression(left: Expression, right: Expression) extends Expression

  def main(args: Array[String]): Unit = {
    println(s"Should be 2: ${calculate("1 + 1")}")
    println(s"Should be 3: ${calculate(" 2-1 + 2 ")}")
    println(s"Should be 23: ${calculate("(1+(4+5+2)-3)+(6+8)")}")
    println(s"Should be -12: ${calculate("- (3 + (4 + 5))")}")
  }

  //  private sealed trait Token
  //
  //  private object Plus extends Token
  //
  //  private object Minus extends Token
  //
  //  private object OpenParentheses extends Token
  //
  //  private object CloseParentheses extends Token
  //
  //  private def tokenize(str: String): Seq[Token] = {
  //    val result = Vector.newBuilder[Token]
  //    var i = 0
  //
  //    while (i < str.length) {
  //      if (str(i) == ' ') {
  //        i += 1
  //      } else if (str(i) == '+') {
  //        i += 1
  //        result.addOne(Plus)
  //      } else if (str(i) == '-') {
  //        i += 1
  //        result.addOne(Minus)
  //      } else if (str(i) == '(') {
  //        i += 1
  //        result.addOne(OpenParentheses)
  //      } else if (str(i) == ')') {
  //        i += 1
  //        result.addOne(CloseParentheses)
  //      } else if (str(i).isDigit) {
  //        val j = i
  //
  //        while (i < str.length && str(i) == ' ') {
  //          i += 1
  //        }
  //
  //        result.addOne(NumberExpression(str.substring(j, i).toInt))
  //      }
  //    }
  //
  //    result.result()
  //  }
  //
}
