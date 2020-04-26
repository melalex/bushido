package com.leetcode.nonlinear

import com.leetcode.TestSpec
import com.leetcode.nonlinear.TreeNode.{buildTree, deserialize, invertTree, isValidBST, kthSmallest, levelOrder, lowestCommonAncestor, maxPathSum, serialize}

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

  "buildTree" when {
    "right oriented input" should {
      "return 3,9,20,?,?,15,7" in {
        serialize(buildTree(Array(3, 9, 20, 15, 7), Array(9, 3, 15, 20, 7))) should be("3,9,20,?,?,15,7")
      }
    }

    "empty input" should {
      "return null" in {
        buildTree(Array(), Array()) should be(null)
      }
    }

    "input [1,2,3] [3,2,1]" should {
      "return 1,2,?,3" in {
        serialize(buildTree(Array(1, 2, 3), Array(3, 2, 1))) should be("1,2,?,3")
      }
    }
  }

  "maxPathSum" when {
    "input 1,2,3" should {
      "return 6" in {
        maxPathSum(deserialize("1,2,3")) should be(6)
      }
    }

    "input -10,9,20,?,?,15,7" should {
      "return 42" in {
        maxPathSum(deserialize("-10,9,20,?,?,15,7")) should be(42)
      }
    }

    "input -3" should {
      "return -3" in {
        maxPathSum(deserialize("-3")) should be(-3)
      }
    }

    "input 1,2" should {
      "return 3" in {
        maxPathSum(deserialize("1,2")) should be(3)
      }
    }

    "input 2,-1" should {
      "return 2" in {
        maxPathSum(deserialize("2,-1")) should be(2)
      }
    }

    "input 1,-2,3" should {
      "return 4" in {
        maxPathSum(deserialize("1,-2,3")) should be(4)
      }
    }

    "input -2,6,?,0,-6" should {
      "return 6" in {
        maxPathSum(deserialize("-2,6,?,0,-6")) should be(6)
      }
    }
  }

  "levelOrder" when {
    "input 3,9,20,?,?,15,7" should {
      "return expected result" in {
        levelOrder(deserialize("3,9,20,?,?,15,7")) should be(List(List(3), List(9, 20), List(15, 7)))
      }
    }
  }

  "kthSmallest" when {
    "input root = [3,1,4,?,2], k = 1" should {
      "return 1" in {
        kthSmallest(deserialize("3,1,4,?,2"), 1) should be(1)
      }
    }

    "input root = [5,3,6,2,4,?,?,1], k = 3" should {
      "return 3" in {
        kthSmallest(deserialize("5,3,6,2,4,?,?,1"), 3) should be(3)
      }
    }

    "input root = [1], k = 1" should {
      "return 1" in {
        kthSmallest(deserialize("1"), 1) should be(1)
      }
    }
  }

  "lowestCommonAncestor" when {
    "input root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8" should {
      "return 6" in {
        lowestCommonAncestor(deserialize("6,2,8,0,4,7,9,?,?,3,5"), new TreeNode(2), new TreeNode(8)).value should be(6)
      }
    }

    "input root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4" should {
      "return 2" in {
        lowestCommonAncestor(deserialize("6,2,8,0,4,7,9,?,?,3,5"), new TreeNode(2), new TreeNode(4)).value should be(2)
      }
    }
  }
}
