package com.leetcode.nonlinear

object TreeNode {

  def isValidBST(root: TreeNode): Boolean = {
    def inner(node: TreeNode, up: Integer, down: Integer): Boolean =
      node == null ||
        ((up == null || node.value < up) &&
          (down == null || node.value > down) &&
          inner(node.left, node.value, down) &&
          inner(node.right, up, node.value))

    inner(root, null, null)
  }

  def invertTree(root: TreeNode): TreeNode = {
    if (root == null) {
      return root
    }

    val queue = collection.mutable.Queue[TreeNode](root)

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      val temp = node.left

      node.left = node.right
      node.right = temp

      if (node.left != null) queue.append(node.left)
      if (node.right != null) queue.append(node.right)
    }

    root
  }
}

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}
