package com.leetcode.structures

import com.leetcode.TestSpec

class ListNodeSpec extends TestSpec {

  "ListNode" when {
    "hasCycle" should {
      "return 1" in {
        val target = ListNode(3, 2, 0, -4)

        target.next.next.next.next = target.next

        ListNode.hasCycle(target) should be(1)
      }

      "return 0" in {
        val target = ListNode(1, 2)

        target.next.next = target

        ListNode.hasCycle(target) should be(0)
      }

      "return -1" in {
        val target = ListNode(3, 2, 0, -4)

        ListNode.hasCycle(target) should be(-1)
      }
    }

  }
}

