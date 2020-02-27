package com.leetcode.structures

object ContainerWithMostWater {

  def maxArea(height: Array[Int]): Int = {

    @inline
    def calculateArea(left: Int, right: Int): Int = (right - left) * Math.min(height(left), height(right))

    @scala.annotation.tailrec
    def iter(left: Int, right: Int, max: Int): Int =
      if (left >= right) max
      else {
        val currentMax = Math.max(calculateArea(left, right), max)
        if (height(left) < height(right)) iter(left + 1, right, currentMax)
        else iter(left, right - 1, currentMax)
      }

    iter(0, height.length - 1, 0)
  }
}
