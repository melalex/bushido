package com.leetcode

object LowestCommonAncestorOfABinaryTree {

  def lowestCommonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    def loop(it: TreeNode) : TreeNode =
      if (it == null) null
      else if (it == p) p
      else if (it == q) q
      else {
        val left = loop(it.left)
        val right = loop(it.right)

        if (left == null) right
        else if (right == null) left
        else it
      }

    loop(root)
  }
}
