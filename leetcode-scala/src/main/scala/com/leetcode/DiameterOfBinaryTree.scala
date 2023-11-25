package com.leetcode

object DiameterOfBinaryTree {

  def diameterOfBinaryTree(root: TreeNode): Int = {

    def dfs(node: TreeNode): (Int, Int) =
      if (node == null) (0, 0)
      else {
        val (maxHeightLeft, maxPathLeft) = dfs(node.left)
        val (maxHeightRight, maxPathRight) = dfs(node.right)

        (math.max(maxHeightLeft + 1, maxHeightRight + 1), math.max(maxHeightLeft + maxHeightRight, math.max(maxPathRight, maxPathLeft)))
      }

    dfs(root)._2
  }

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }

  def main(args: Array[String]): Unit = {
    println(s"Should be 3: ${diameterOfBinaryTree(new TreeNode(1, new TreeNode(2 , new TreeNode(4), new TreeNode(5)), new TreeNode(3)))}")
  }
}
