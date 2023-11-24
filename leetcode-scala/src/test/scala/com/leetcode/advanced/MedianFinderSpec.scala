package com.leetcode.advanced

import com.leetcode.{MedianFinder, TestSpec}

class MedianFinderSpec extends TestSpec {

  "MedianFinder" when {
    "input 1,2,3" should {
      "return expected result" in {
        val obj = new MedianFinder()

        obj.addNum(1)
        obj.addNum(2)
        obj.findMedian() should be(1.5)
        obj.addNum(3)
        obj.findMedian() should be(2)
      }
    }

    "input 1..10" should {
      "return expected result" in {
        val obj = new MedianFinder()

        obj.addNum(1)
        obj.findMedian() should be(1)
        obj.addNum(2)
        obj.findMedian() should be(1.5)
        obj.addNum(3)
        obj.findMedian() should be(2)
        obj.addNum(4)
        obj.findMedian() should be(2.5)
        obj.addNum(5)
        obj.findMedian() should be(3)
        obj.addNum(6)
        obj.findMedian() should be(3.5)
        obj.addNum(7)
        obj.findMedian() should be(4)
        obj.addNum(8)
        obj.findMedian() should be(4.5)
        obj.addNum(9)
        obj.findMedian() should be(5)
        obj.addNum(10)
        obj.findMedian() should be(5.5)
      }
    }
  }
}
