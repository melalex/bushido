package com.melalex.leetcode.interview.saldo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a Java program that takes standard input, where each line contains an email address eg.
 * joeblogs@saldoaaps.com andrew.smith@gmail.com ...
 * and outputs the 10 domains (or less if there aren't that many) that appear the most often with a count of the number of times it appears after each domain. eg.
 * saldoaaps.com 2553 yahoo.com 1315 ...
 * and up to 8 more lines.
 * Please treat this exercise as you would with production code. Explain why your solution is optimal.
 */
public class TopNEmails {

  private static final String EOI = "0";
  private static final String AT = "@";
  private static final int TOP_N = 10;

  public static void main(String[] args) {
    topNEmail(System.in, System.out, TOP_N);
  }

  @SuppressWarnings("SameParameterValue")
  private static void topNEmail(InputStream in, PrintStream out, int n) {
    var frequencies = calculateEmailFrequencies(in);
    var result = findTopNFrequencies(frequencies, n);

    printResult(result, out);
  }

  private static Map<String, Long> calculateEmailFrequencies(InputStream in) {
    try (var scanner = new Scanner(in)) {
      return Stream.generate(scanner::next)
          .takeWhile(it -> !it.equals(EOI))
          .filter(it -> it.contains(AT))
          .map(it -> it.split(AT)[1])
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
  }

  private static List<Map.Entry<String, Long>> findTopNFrequencies(Map<String, Long> frequencies, int n) {
    var queue = new PriorityQueue<Map.Entry<String, Long>>(n + 1, Comparator.comparingLong(Map.Entry::getValue));

    for (var entry : frequencies.entrySet()) {
      queue.offer(entry);

      if (queue.size() > n) {
        queue.poll();
      }
    }

    var result = new LinkedList<Map.Entry<String, Long>>();

    while (!queue.isEmpty()) {
      result.addFirst(queue.poll());
    }

    return result;
  }

  private static void printResult(List<Map.Entry<String, Long>> result, PrintStream out) {
    for (var it : result) {
      out.println(it.getKey() + " -> " + it.getValue());
    }
  }
}
