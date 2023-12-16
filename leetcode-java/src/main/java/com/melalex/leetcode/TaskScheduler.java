package com.melalex.leetcode;

import java.util.Arrays;

public class TaskScheduler {

  private static final int Z_INDEX = 'Z' - 'A';

  public int leastInterval(char[] tasks, int n) {
    var taskMap = new int[Z_INDEX + 1];

    for (var task : tasks) {
      taskMap[task - 'A']++;
    }

    Arrays.sort(taskMap);

    var maxFreq = taskMap[Z_INDEX];
    var idleTime = (maxFreq-1) * n;

    for (var i = Z_INDEX - 1; i >= 0; i--) {
      idleTime-= Math.min(maxFreq-1, taskMap[i]);
    }

    return tasks.length + Math.max(idleTime, 0);
  }

  public static void main(String[] args) {
    var app = new TaskScheduler();

    System.out.println(app.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
  }
}
