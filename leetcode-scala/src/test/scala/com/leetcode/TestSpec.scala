package com.leetcode

import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Seconds, Span}
import org.scalatest.wordspec.AnyWordSpec

abstract class TestSpec extends AnyWordSpec with Matchers with TimeLimitedTests {

  val timeLimit = Span(5, Seconds)

  def asCharMatrix(string: String): Array[Array[Char]] =
    string.stripMargin
      .linesIterator.map(_.toCharArray)
      .toArray


  def asIntMatrix(string: String): Array[Array[Int]] =
    string.stripMargin
      .linesIterator.map(s => s.map(c => Integer.valueOf(c.toString).toInt).toArray)
      .toArray

}
