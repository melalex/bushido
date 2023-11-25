package com.leetcode

object MiddleOfTheLinkedList {

  def middleNode(head: ListNode): ListNode = {

    @scala.annotation.tailrec
    def middleNode(fast: ListNode, slow: ListNode): ListNode = {
      if (fast == null) slow
      else if (fast.next == null) slow
      else middleNode(fast.next.next, slow.next)
    }

    middleNode(head, head)
  }

  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
}
