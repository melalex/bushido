package com.leetcode.dynamic

object MaximumProfitInJobScheduling {

  def jobScheduling(startTime: Array[Int], endTime: Array[Int], profit: Array[Int]): Int = {
    val jobsCount = startTime.length
    val orderedJobs = Vector.range(0, jobsCount).sortBy(startTime)
    val cache = Array.ofDim[Int](jobsCount)

    def jobSchedulingInternal(jobIndex: Int): Int = {
      if (jobIndex == -1 || jobIndex >= jobsCount) 0
      else if (cache(jobIndex) != 0) cache(jobIndex)
      else {
        val job = orderedJobs(jobIndex)

        val next = findNext(jobIndex + 1, jobsCount - 1, endTime(job))

        val res = math.max(
          jobSchedulingInternal(next) + profit(job),
          jobSchedulingInternal(jobIndex + 1)
        )

        cache(jobIndex) = res

        res
      }
    }

    @scala.annotation.tailrec
    def findNext(low: Int, high: Int, endTime: Int): Int = {
      if (low > high)
        return -1

      val middleIndex = low + (high - low) / 2
      val middleJob = orderedJobs(middleIndex)

      if (startTime(middleJob) >= endTime && startTime(orderedJobs(middleIndex - 1)) < endTime) middleIndex
      else if (startTime(middleJob) >= endTime) findNext(low, middleIndex - 1, endTime)
      else findNext(middleIndex + 1, high, endTime)
    }

    jobSchedulingInternal(0)
  }

  def main(args: Array[String]): Unit = {
    println("Should be 7: " + jobScheduling(Array[Int](1, 2, 2, 3), Array[Int](2, 5, 3, 4), Array[Int](3, 4, 1, 2)))
    println("Should be 120: " + jobScheduling(Array[Int](1, 2, 3, 3), Array[Int](3, 4, 5, 6), Array[Int](50, 10, 40, 70)))
    println("Should be 150: " + jobScheduling(Array[Int](1, 2, 3, 4, 6), Array[Int](3, 5, 10, 6, 9), Array[Int](20, 20, 100, 70, 60)))
    println("Should be 6: " + jobScheduling(Array[Int](1, 1, 1), Array[Int](2, 3, 4), Array[Int](5, 6, 4)))
    println("Should be 63: " + jobScheduling(Array[Int](15, 44, 15, 47, 11, 18, 5, 41, 38, 25, 19, 25), Array[Int](33, 48, 20, 49, 37, 22, 32, 48, 39, 37, 38, 40), Array[Int](18, 19, 16, 1, 5, 12, 17, 7, 19, 9, 18, 9)))
    println("Should be 998: " + jobScheduling(Array[Int](341, 22, 175, 424, 574, 687, 952, 439, 51, 562, 962, 890, 250, 47, 945, 914, 835, 937, 419, 343, 125, 809, 807, 959, 403, 861, 296, 39, 802, 562, 811, 991, 209, 375, 78, 685, 592, 409, 369, 478, 417, 162, 938, 298, 618, 745, 888, 463, 213, 351, 406, 840, 779, 299, 90, 846, 58, 235, 725, 676, 239, 256, 996, 362, 819, 622, 449, 880, 951, 314, 425, 127, 299, 326, 576, 743, 740, 604, 151, 391, 925, 605, 770, 253, 670, 507, 306, 294, 519, 184, 848, 586, 593, 909, 163, 129, 685, 481, 258, 764), Array[Int](462, 101, 820, 999, 900, 692, 991, 512, 655, 578, 996, 979, 425, 893, 975, 960, 930, 991, 987, 524, 208, 901, 841, 961, 878, 882, 412, 795, 937, 807, 957, 994, 963, 716, 608, 774, 681, 637, 635, 660, 750, 632, 948, 771, 943, 801, 985, 476, 532, 535, 929, 943, 837, 565, 375, 854, 174, 698, 820, 710, 566, 464, 997, 551, 884, 844, 830, 916, 970, 965, 585, 631, 785, 632, 892, 954, 803, 764, 283, 477, 970, 616, 794, 911, 771, 797, 776, 686, 895, 721, 917, 920, 975, 984, 996, 471, 770, 656, 977, 922), Array[Int](85, 95, 14, 72, 17, 3, 86, 65, 50, 50, 42, 75, 40, 87, 35, 78, 47, 74, 92, 10, 100, 29, 55, 57, 51, 34, 10, 96, 14, 71, 63, 99, 8, 37, 16, 71, 10, 71, 83, 88, 68, 79, 27, 87, 3, 58, 56, 43, 89, 31, 16, 9, 49, 84, 62, 30, 35, 7, 27, 34, 24, 33, 100, 25, 90, 79, 58, 21, 31, 30, 61, 46, 36, 45, 85, 62, 91, 54, 28, 63, 50, 69, 48, 36, 77, 39, 19, 97, 20, 39, 48, 72, 37, 67, 72, 46, 54, 37, 53, 30)))
  }
}
