package com.leetcode

object QueueReconstructionByHeight {

  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    val result = Array.ofDim[Array[Int]](people.length)

    def isOccupied(i: Int) = result(i) != null

    val sortedByHeight = people.sortBy(_ (0))

    for (entry <- sortedByHeight) {
      var k = entry(1)
      var i = 0

      while (k > 0 || isOccupied(i)) {
        if (!isOccupied(i) || result(i)(0) >= entry(0)) {
          k -= 1
        }

        i += 1
      }

      result(i) = entry
    }

    result
  }

  private def printArray[A](arr: Array[A]) =
    if (arr == null) "null"
    else arr.mkString("[", ", ", "]")

  def main(args: Array[String]): Unit = {
    val input = Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))
    println("input:  " + printArray(input.map(printArray)))
    println("output: " + printArray(reconstructQueue(input).map(printArray)))
  }
}
