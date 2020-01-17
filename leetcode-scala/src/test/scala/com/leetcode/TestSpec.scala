package com.leetcode

import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Seconds, Span}
import org.scalatest.wordspec.AnyWordSpec

abstract class TestSpec extends AnyWordSpec with Matchers with TimeLimitedTests {

  val timeLimit = Span(5, Seconds)
}
