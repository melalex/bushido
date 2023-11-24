package com.melalex.leetcode;

public class MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    var resultHead = new ListNode();
    var result = resultHead;
    var list1Runner = list1;
    var list2Runner = list2;

    while (list1Runner != null || list2Runner != null) {
      if (list2Runner != null && (list1Runner == null || list1Runner.val > list2Runner.val)) {
        result.next = new ListNode(list2Runner.val);
        list2Runner = list2Runner.next;
      } else {
        result.next = new ListNode(list1Runner.val);
        list1Runner = list1Runner.next;
      }
      result = result.next;
    }

    return resultHead.next;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    var app = new MergeTwoSortedLists();

    app.mergeTwoLists(new ListNode(1), null);
  }
}
