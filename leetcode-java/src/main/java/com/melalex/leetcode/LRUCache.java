package com.melalex.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

  private final int capacity;

  private final Map<Integer, ListNode> cache;

  private ListNode head = NullListNode.getInstance();
  private ListNode tail = NullListNode.getInstance();

  private LRUCache(int capacity, Map<Integer, ListNode> cache) {
    this.capacity = capacity;
    this.cache = cache;
  }

  public LRUCache(int capacity) {
    this(capacity, new HashMap<>(capacity + 1));
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    } else if (cache.size() == 1) {
      return cache.get(key).getValue();
    } else {
      var node = cache.get(key);

      if (node == head) {
        head = node.getNext();
      }

      if (node != tail) {
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        node.setNext(NullListNode.getInstance());
        node.setPrev(tail);
        tail.setNext(node);

        tail = node;
      }

      return node.getValue();
    }
  }

  public void put(int key, int value) {
    if (get(key) != -1) {
      tail.setValue(value);
    } else {
      var node = new ActualListNode(key, value);

      if (cache.isEmpty()) {
        head = node;
      }

      tail.setNext(node);
      node.setPrev(tail);

      tail = node;

      cache.put(key, node);

      if (cache.size() > capacity) {
        cache.remove(head.getKey());

        head = head.getNext();
        head.setPrev(NullListNode.getInstance());
      }
    }
  }

  private interface ListNode {

    int getKey();

    int getValue();

    void setValue(int value);

    ListNode getNext();

    void setNext(ListNode next);

    ListNode getPrev();

    void setPrev(ListNode prev);
  }

  private static class NullListNode implements ListNode {

    private static final ListNode INSTANCE = new NullListNode();

    public static ListNode getInstance() {
      return INSTANCE;
    }

    private NullListNode() {
    }

    @Override
    public int getKey() {
      return -1;
    }

    @Override
    public int getValue() {
      return -1;
    }

    @Override
    public void setValue(int value) {

    }

    @Override
    public ListNode getNext() {
      return this;
    }

    @Override
    public void setNext(ListNode next) {

    }

    @Override
    public ListNode getPrev() {
      return this;
    }

    @Override
    public void setPrev(ListNode prev) {

    }
  }

  private static class ActualListNode implements ListNode {

    private final int key;
    private int value;
    private ListNode next = NullListNode.getInstance();
    private ListNode prev = NullListNode.getInstance();

    private ActualListNode(int key, int value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public int getKey() {
      return key;
    }

    @Override
    public int getValue() {
      return value;
    }

    @Override
    public void setValue(int value) {
      this.value = value;
    }

    @Override
    public ListNode getNext() {
      return next;
    }

    @Override
    public void setNext(ListNode next) {
      this.next = next;
    }

    @Override
    public ListNode getPrev() {
      return prev;
    }

    @Override
    public void setPrev(ListNode prev) {
      this.prev = prev;
    }
  }

  public static void main(String[] args) {
    var lRUCache = new LRUCache(2);
    lRUCache.put(2, 1);
    lRUCache.put(3, 2);

    System.out.println(lRUCache.get(3));
    System.out.println(lRUCache.get(2));

    lRUCache.put(4, 3);

    System.out.println(lRUCache.get(2));
    System.out.println(lRUCache.get(3));
    System.out.println(lRUCache.get(4));
  }
}
