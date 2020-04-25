package com.leetcode.nonlinear

object CourseSchedule {

  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val occurrences = new Array[Int](numCourses)

    for (pre <- prerequisites) {
      occurrences(pre(0)) += 1
    }

    @scala.annotation.tailrec
    def buildStack(i: Int, acc: List[Int]): List[Int] =
      if (i >= occurrences.length) acc
      else if (occurrences(i) == 0) buildStack(i + 1, i :: acc)
      else buildStack(i + 1, acc)

    @scala.annotation.tailrec
    def topologicalSort(stack: List[Int], depth: Int): Int = stack match {
      case Nil => depth
      case head :: next =>
        var newStack = next

        for (pre <- prerequisites; if pre(1) == head) {
          occurrences(pre(0)) -= 1

          if (occurrences(pre(0)) == 0) {
            newStack = pre(0) :: newStack
          }
        }

        topologicalSort(newStack, depth + 1)
    }

    topologicalSort(buildStack(0, Nil), 0) == numCourses
  }
}
