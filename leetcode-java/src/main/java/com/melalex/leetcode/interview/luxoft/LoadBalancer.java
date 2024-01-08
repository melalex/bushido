package com.melalex.leetcode.interview.luxoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LoadBalancer {

  public static List<Integer> getServerIndex(int n, List<Integer> arrival, List<Integer> burstTime) {
    var m = arrival.size();
    var sortedArrival = IntStream.range(0, m).mapToObj(i -> Map.entry(i, arrival.get(i)))
        .sorted(Comparator.comparingInt(Map.Entry::getValue))
        .collect(Collectors.toList());

    var availableAfter = new PriorityQueue<>(Comparator.<Map.Entry<Integer, Integer>>comparingInt(Map.Entry::getValue).thenComparingInt(Map.Entry::getKey));
    var result = new ArrayList<Map.Entry<Integer, Integer>>(m);

    for (var i = 0; i < n; i++) {
      availableAfter.offer(Map.entry(i + 1, 0));
    }

    for (var iToArrival : sortedArrival) {
      var now = iToArrival.getValue();
      var available = -1;

      if (availableAfter.peek().getValue() <= now) {
        var curr = availableAfter.poll();
        available = curr.getKey();
        availableAfter.offer(Map.entry(available, now + burstTime.get(iToArrival.getKey())));
      }

      result.add(Map.entry(iToArrival.getKey(), available));
    }

    return result.stream()
        .sorted(Comparator.comparingInt(Map.Entry::getKey))
        .map(Map.Entry::getValue)
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    System.out.println(LoadBalancer.getServerIndex(4, List.of(3, 5, 1, 6, 8), List.of(9, 2, 10, 4, 5)));
  }
}
