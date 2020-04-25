package com.leetcode.nonlinear

object CourseSchedule {

  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    if (prerequisites == null || prerequisites.isEmpty) {
      return true
    }

    val map = prerequisites.groupMap(a => a(0))(a => a(1))

    def isNotCycled(root: Int, acc: Int): Boolean =
      acc < numCourses && (!map.contains(root) || map(root).forall(node => isNotCycled(node, acc + 1)))


    map.forall(entry => isNotCycled(entry._1, 0))
  }
}
