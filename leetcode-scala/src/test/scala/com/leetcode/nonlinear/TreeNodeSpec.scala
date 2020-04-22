package com.leetcode.nonlinear

import com.leetcode.TestSpec
import com.leetcode.nonlinear.TreeNode.{deserialize, invertTree, isValidBST, serialize}

class TreeNodeSpec extends TestSpec {

  "isValidBST" when {
    "tree is valid" should {
      "return true" in {
        val root = new TreeNode(2)
        val left = new TreeNode(1)
        val right = new TreeNode(3)

        root.left = left
        root.right = right

        isValidBST(root) should be(true)
      }
    }

    "tree is not valid" should {
      "return false" in {
        val root = new TreeNode(5)
        val one = new TreeNode(1)
        val four = new TreeNode(4)
        val three = new TreeNode(3)
        val six = new TreeNode(6)

        root.left = one
        root.right = four
        four.left = three
        four.right = six

        isValidBST(root) should be(false)
      }
    }

    "tree with the same value" should {
      "return false" in {
        val root = new TreeNode(1)
        val one = new TreeNode(1)

        root.right = one

        isValidBST(root) should be(false)
      }
    }
  }

  "invertTree" when {
    "input some tree" should {
      "return some response" in {
        val root = new TreeNode(2)
        val left = new TreeNode(1)
        val right = new TreeNode(3)

        root.left = left
        root.right = right

        invertTree(root) should not be null
      }
    }
  }

  "deserialize" when {
    "input 5,1,?,4,?,3,?,6" should {
      "return expected result" in {
        val expected = "5,1,?,4,?,3,?,6"

        val actual = serialize(deserialize(expected))

        actual should be(expected)
      }
    }

    "input 1,2,3,?,?,4,5" should {
      "return expected result" in {
        val expected = "1,2,3,?,?,4,5"

        val actual = serialize(deserialize(expected))

        actual should be(expected)
      }
    }

    "input null" should {
      "return expected result" in {
        deserialize(serialize(null)) should be(null)
      }
    }
  }
}
