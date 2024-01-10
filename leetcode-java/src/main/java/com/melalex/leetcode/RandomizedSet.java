package com.melalex.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

  private final Map<Integer, Integer> map = new HashMap<>();
  private final List<Integer> list = new ArrayList<>();
  private final Random random = new Random();

  public RandomizedSet() {

  }

  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    }

    map.put(val, list.size());
    list.add(val);

    return true;
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {

      return false;
    }

    int idx = map.get(val);
    int lastIdx = list.size() - 1;
    if (idx != lastIdx) {
      int lastVal = list.get(lastIdx);
      list.set(idx, lastVal);
      map.put(lastVal, idx);
    }
    list.remove(lastIdx);
    map.remove(val);
    return true;
  }

  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }

  public static void main(String[] args) {
    var set = new RandomizedSet();

    System.out.println(set.remove(0));
    System.out.println(set.remove(0));
    System.out.println(set.insert(0));
    System.out.println(set.getRandom());
    System.out.println(set.remove(0));
    System.out.println(set.insert(0));
  }
}
