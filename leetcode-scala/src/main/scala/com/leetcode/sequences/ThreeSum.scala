package com.leetcode.sequences

object ThreeSum {

  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val mapping = nums.zipWithIndex
      .map { case (n, i) => n -> i }
      .toMap

    nums.to(LazyList)
      .zipWithIndex
      .map { case (value, index) => (0 - value, index) }
      .flatMap {
        case (target, valIndex) =>
          nums.to(LazyList)
            .zipWithIndex
            .filter { case (elem, _) => mapping.contains(target - elem) }
            .map { case (elem, index) => (index, mapping(target - elem))}
            .filterNot { case (left, right) => left == right }
            .filterNot { case (left, _) => left == valIndex }
            .filterNot { case (_, right) => right == valIndex }
            .map { case (left, right) => List(nums(valIndex), nums(left), nums(right)) }
      }
      .distinctBy(_.toSet)
      .toList
  }
}
