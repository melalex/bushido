package com.leetcode.sequences

object MaximumProductSubarray {

  type SliceAndNegatives = (Int, Int, Int, Int, Int)

  def maxProduct(nums: Array[Int]): Int = {
    var slices = List[SliceAndNegatives]()
    var firstNegative = Int.MaxValue
    var lastNegative = Int.MinValue
    var negativesCount = 0
    var sliceStart = 0
    var maxProduct = 1

    for (i <- nums.indices) {
      val elem = nums(i)

      maxProduct *= elem

      if (elem < 0) {
        negativesCount += 1
        firstNegative = Math.min(firstNegative, i)
        lastNegative = Math.max(lastNegative, i)
      } else if (elem == 0) {
        slices = (sliceStart, i, firstNegative, lastNegative, negativesCount) :: slices
        sliceStart = i + 1
        firstNegative = Int.MaxValue
        lastNegative = Int.MinValue
        negativesCount = 0
      }
    }

    slices = (sliceStart, nums.length, firstNegative, lastNegative, negativesCount) :: slices

    if (maxProduct >= 1) {
      return maxProduct
    }

    for ((from, until, firstNeg, lastNeg, negCount) <- slices) {
      maxProduct = Math.max(sliceMaxProduct(nums, from, until, firstNeg, lastNeg, negCount), maxProduct)
    }

    maxProduct
  }

  @inline
  private def sliceMaxProduct(nums: Array[Int], first: Int, last: Int, firstNeg: Int, lastNeg: Int, negCount: Int): Int = {
    if (negCount % 2 == 0) product(nums, first until last)
    else Math.max(
      product(nums, first until lastNeg),
      product(nums, firstNeg + 1 until last)
    )
  }

  private def product(nums: Array[Int], range: Range): Int = {
    if (range.isEmpty) {
      return Int.MinValue
    }

    var result = 1

    for (i <- range) {
      result = nums(i) * result
    }

    result
  }
}
