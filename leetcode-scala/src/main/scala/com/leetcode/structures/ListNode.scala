package com.leetcode.structures

object ListNode {

  def reverseList(head: ListNode): ListNode = {

    @scala.annotation.tailrec
    def iter(source: ListNode, dest: ListNode): ListNode =
      if (source == null) dest
      else {
        val node = new ListNode(source.x)
        node.next = dest
        iter(source.next, node)
      }

    iter(head, null)
  }

  def hasCycle(head: ListNode): Int = {

    @scala.annotation.tailrec
    def iter(source: ListNode, index: Int, acc: Map[ListNode, Int]): Int =
      if (source == null) -1
      else if (acc.contains(source)) acc(source)
      else iter(source.next, index + 1, acc.updated(source, index))

    iter(head, 0, Map[ListNode, Int]())
  }

  def apply(seq: Int*): ListNode = seq.foldRight[ListNode](null) { (x, acc) =>
    val result = new ListNode(x)
    result.next = acc
    result
  }
}

class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}
