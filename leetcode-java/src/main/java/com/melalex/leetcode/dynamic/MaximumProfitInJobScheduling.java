package com.melalex.leetcode.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumProfitInJobScheduling {

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    var jobs = IntStream.range(0, startTime.length)
        .boxed()
        .collect(Collectors.toUnmodifiableSet());

    return jobSchedulingInternal(startTime, endTime, profit, jobs, new HashMap<>());
  }

  private int jobSchedulingInternal(
      int[] startTime,
      int[] endTime,
      int[] profit,
      Set<Integer> remainingJobs,
      Map<Set<Integer>, Integer> cache
  ) {
    if (remainingJobs.isEmpty()) {
      return 0;
    } else if (cache.containsKey(remainingJobs)) {
//      System.out.println("Get from cache: " + remainingJobs + " -> " + cache.get(remainingJobs));
      return cache.get(remainingJobs);
    } else {
      var result = remainingJobs.stream()
          .mapToInt(job ->
              jobSchedulingInternal(
                  startTime,
                  endTime,
                  profit,
                  filterOutOverlapping(startTime, endTime, remainingJobs, job),
                  cache
              ) + profit[job]
          )
          .max()
          .orElse(0);

      // System.out.println("Put to cache: " + remainingJobs + " -> " + result);

      cache.put(remainingJobs, result);

      System.out.println("Cache size: " + cache.size());

      return result;
    }
  }

  private Set<Integer> filterOutOverlapping(int[] startTime, int[] endTime, Set<Integer> jobs, Integer job) {
    return jobs.stream()
        .filter(it -> isNotOverlapping(startTime, endTime, job, it))
        .collect(Collectors.toUnmodifiableSet());
  }

  public boolean isNotOverlapping(int[] startTime, int[] endTime, int jobA, int jobB) {
    return (startTime[jobA] <= startTime[jobB] && endTime[jobA] <= startTime[jobB]) || (startTime[jobB] <= startTime[jobA] && endTime[jobB] <= startTime[jobA]);
  }

  public static void main(String[] args) {
    var app = new MaximumProfitInJobScheduling();

    System.out.println("Should be 120: " + app.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
    System.out.println("Should be 150: " + app.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
    System.out.println("Should be 6: " + app.jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
    System.out.println("Should be 63: " + app.jobScheduling(new int[]{15, 44, 15, 47, 11, 18, 5, 41, 38, 25, 19, 25}, new int[]{33, 48, 20, 49, 37, 22, 32, 48, 39, 37, 38, 40}, new int[]{18, 19, 16, 1, 5, 12, 17, 7, 19, 9, 18, 9}));
    System.out.println("Should be 63: " + app.jobScheduling(new int[]{341,22,175,424,574,687,952,439,51,562,962,890,250,47,945,914,835,937,419,343,125,809,807,959,403,861,296,39,802,562,811,991,209,375,78,685,592,409,369,478,417,162,938,298,618,745,888,463,213,351,406,840,779,299,90,846,58,235,725,676,239,256,996,362,819,622,449,880,951,314,425,127,299,326,576,743,740,604,151,391,925,605,770,253,670,507,306,294,519,184,848,586,593,909,163,129,685,481,258,764}, new int[]{462,101,820,999,900,692,991,512,655,578,996,979,425,893,975,960,930,991,987,524,208,901,841,961,878,882,412,795,937,807,957,994,963,716,608,774,681,637,635,660,750,632,948,771,943,801,985,476,532,535,929,943,837,565,375,854,174,698,820,710,566,464,997,551,884,844,830,916,970,965,585,631,785,632,892,954,803,764,283,477,970,616,794,911,771,797,776,686,895,721,917,920,975,984,996,471,770,656,977,922}, new int[]{85,95,14,72,17,3,86,65,50,50,42,75,40,87,35,78,47,74,92,10,100,29,55,57,51,34,10,96,14,71,63,99,8,37,16,71,10,71,83,88,68,79,27,87,3,58,56,43,89,31,16,9,49,84,62,30,35,7,27,34,24,33,100,25,90,79,58,21,31,30,61,46,36,45,85,62,91,54,28,63,50,69,48,36,77,39,19,97,20,39,48,72,37,67,72,46,54,37,53,30}));
  }
}
