package com.leetcode.sequences

object MaxSubArray {

  def maxSubArray(nums: Array[Int]): Int = {
    var leftPick = 0
    var rightPick = 0
    var centralValley = 0
    var result = Int.MinValue
    var isValley = true

    for (elem <- nums) {
      if (elem > 0) {
        rightPick += elem
        isValley = false
      } else if (isValley) {
        centralValley += elem
        result = Math.max(elem, result)
      } else {
        leftPick = tryMerge(leftPick, centralValley, rightPick)
        result = Math.max(leftPick, result)

        rightPick = 0
        centralValley = elem
        isValley = true
      }
    }

    if (!isValley) {
      leftPick = tryMerge(leftPick, centralValley, rightPick)
      result = Math.max(leftPick, result)
    }

    result
  }

  private def tryMerge(leftPick: Int, centralValley: Int, rightPick: Int): Int = {
    val merged = leftPick + centralValley + rightPick

    Math.max(merged, rightPick)
  }
}
