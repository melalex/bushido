package com.leetcode.structures

import com.leetcode.TestSpec
import com.leetcode.structures.ListNode.{hasCycle, removeNthFromEnd, toList}

class ListNodeSpec extends TestSpec {

  "ListNode" when {
    "hasCycle" should {
      "return 1" in {
        val target = ListNode(3, 2, 0, -4)

        target.next.next.next.next = target.next

        hasCycle(target) should be(1)
      }

      "return 0" in {
        val target = ListNode(1, 2)

        target.next.next = target

        hasCycle(target) should be(0)
      }

      "return -1" in {
        val target = ListNode(3, 2, 0, -4)

        hasCycle(target) should be(-1)
      }
    }

    "removeNthFromEnd" should {
      "return expected result" in {
        toList(removeNthFromEnd(ListNode(1, 2, 3, 4, 5), 2)) should be(toList(ListNode(1, 2, 3, 5)))
      }

      "return null" in {
        removeNthFromEnd(ListNode(1), 1) should be(null)
      }

      "return head" in {
        toList(removeNthFromEnd(ListNode(1, 2), 1)) should be(toList(ListNode(1)))
      }
    }
  }
}

