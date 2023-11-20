package com.leetcode.advanced

object SortList {

  case class ListNode(var x: Int = 0, var next: ListNode = null) {

    override def toString: String = x + " -> " + next
  }

  case class LinkedList(var first: ListNode = null, private var last: ListNode = null) {

    def append(elem: ListNode): LinkedList = {
      elem.next = null

      if (first == null) {
        first = elem
      }
      else {
        last.next = elem
      }

      last = elem

      this
    }

    override def toString: String = first.toString
  }

  def sortList(head: ListNode): ListNode = {

    @scala.annotation.tailrec
    def size(node: ListNode, acc: Int = 0): Int =
      if (node == null) acc
      else size(node.next, acc + 1)

    @scala.annotation.tailrec
    def skip(node: ListNode, count: Int): ListNode =
      if (node == null || count == 0) node
      else skip(node.next, count - 1)

    @scala.annotation.tailrec
    def merge(left: ListNode, right: ListNode, leftSize: Int, rightSize: Int, acc: LinkedList = LinkedList()): ListNode =
      if ((left == null && right == null) || (leftSize == 0 && rightSize == 0)) acc.first
      else if (right == null || rightSize == 0 || (leftSize != 0 && left != null && left.x < right.x)) merge(left.next, right, leftSize - 1, rightSize, acc.append(left))
      else merge(left, right.next, leftSize, rightSize - 1, acc.append(right))

    def sort(node: ListNode, size: Int): ListNode =
      if (size == 0) null
      else if (size == 1) node
      else {
        val leftSize = size / 2
        val rightSize = size - leftSize
        val rightHalf = skip(node, leftSize)

        val left = sort(node, leftSize)
        val right = sort(rightHalf, rightSize)

        merge(left, right, leftSize, rightSize)
      }

    sort(head, size(head))
  }

  def main(args: Array[String]): Unit = {
    println("input: " + ListNode(-1, ListNode(5, ListNode(3, ListNode(4, ListNode())))))
    println("output: " + sortList(ListNode(-1, ListNode(5, ListNode(3, ListNode(4, ListNode()))))))
  }
}
