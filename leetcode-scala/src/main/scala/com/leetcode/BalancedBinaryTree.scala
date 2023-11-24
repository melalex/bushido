package com.leetcode

object BalancedBinaryTree {

  def isBalanced(root: TreeNode): Boolean = {
    def dfs(it: TreeNode, acc: Int): (Boolean, Int) =
      if (it == null) (true, acc)
      else {
        val (isLeftBalanced, leftHeight) = dfs(it.left, acc + 1)
        val (isRightBalanced, rightHeight) = dfs(it.right, acc + 1)

        (isLeftBalanced && isRightBalanced && math.abs(leftHeight - rightHeight) <= 1, math.max(leftHeight, rightHeight))
      }

    dfs(root, 0)._1
  }

  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
    var value: Int = _value
    var left: TreeNode = _left
    var right: TreeNode = _right
  }
}
