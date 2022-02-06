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

  @scala.annotation.tailrec
  def get(head: ListNode, i: Int): ListNode =
    if (i == 0 || head == null) head
    else get(head.next, i - 1)

  def count(head: ListNode): Int = {

    @scala.annotation.tailrec
    def iter(head: ListNode, acc: Int): Int =
      if (head == null) acc
      else iter(head.next, acc + 1)

    iter(head, 0)
  }

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {

    @scala.annotation.tailrec
    def iter(head: ListNode, nth: ListNode): Unit =
      if (nth == null) head.next = head.next.next
      else iter(head.next, nth.next)

    val dummy = new ListNode(0)
    dummy.next = head

    val nth = get(dummy, n + 1)

    iter(dummy, nth)

    dummy.next
  }

  def toList(listNode: ListNode): List[Int] =
    if (listNode == null) Nil
    else listNode.x :: toList(listNode.next)

  def apply(seq: Int*): ListNode = seq.foldRight[ListNode](null) { (x, acc) =>
    val result = new ListNode(x)
    result.next = acc
    result
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    val zero = new ListNode()
    val queue = collection.mutable.PriorityQueue.empty[ListNode](Ordering.by[ListNode, Int](_.x).reverse)
    var last = zero

    for (list <- lists; if list != null) {
      queue += list
    }

    while (queue.nonEmpty) {
      val node = queue.dequeue()

      last.next = node
      last = node

      if (node.next != null) {
        queue += node.next
      }
    }

    zero.next
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def next(node: ListNode) =
      if (node == null) null
      else node.next

    def value(node: ListNode) =
      if (node == null) 0
      else node.x

    def iter(l1: ListNode, l2: ListNode, remaining: Int): ListNode = {
      if (l1 == null && l2 == null && remaining == 0) null
      else if (l1 == null && l2 == null) new ListNode(remaining)
      else {
        val sum = value(l1) + value(l2) + remaining

        new ListNode(sum % 10, iter(next(l1), next(l2), sum / 10))
      }
    }

    iter(l1, l2, 0)
  }
}

class ListNode(_x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x
}
