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
    var last = zero

    while (lists.exists(_ != null)) {
      val i = lists.indexOf(lists.minBy(n => if (n == null) Int.MaxValue else n.x))
      val node = lists(i)

      last.next = node
      last = node

      lists(i) = node.next
    }

    zero.next
  }
}

case class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}
