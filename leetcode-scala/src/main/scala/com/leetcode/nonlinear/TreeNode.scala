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
}

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}
