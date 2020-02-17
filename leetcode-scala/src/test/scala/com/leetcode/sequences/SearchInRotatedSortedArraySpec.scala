package com.leetcode.sequences

import com.leetcode.TestSpec
import com.leetcode.sequences.SearchInRotatedSortedArray.search

class SearchInRotatedSortedArraySpec extends TestSpec {

  "SearchInRotatedSortedArray" when {
    "input: [4, 5, 6, 7, 0, 1, 2]" should {
      "return 4" in {
        search(Array(4, 5, 6, 7, 0, 1, 2), 0) should be(4)
      }

      "return 2" in {
        search(Array(4, 5, 6, 7, 0, 1, 2), 6) should be(2)
      }

      "return -1" in {
        search(Array(4, 5, 6, 7, 0, 1, 2), 3) should be(-1)
      }

      "return 6" in {
        search(Array(4, 5, 6, 7, 0, 1, 2), 2) should be(6)
      }
    }

    "input: [1]" should {
      "return -1" in {
        search(Array(1), 0) should be(-1)
      }
    }

    "input: []" should {
      "return -1" in {
        search(Array(), 5) should be(-1)
      }
    }

    "input: [3, 5, 1]" should {
      "return 0" in {
        search(Array(3, 5, 1), 3) should be(0)
      }
    }
  }
}
