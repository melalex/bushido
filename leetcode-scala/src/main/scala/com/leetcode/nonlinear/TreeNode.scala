package com.leetcode.nonlinear

object TreeNode {

  private val NULL = "?"

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

  def serialize(root: TreeNode): String = {
    if (root == null) {
      return NULL
    }

    def asString(node: TreeNode): String = if (node == null) NULL else node.value.toString

    val result = collection.mutable.Queue[String](asString(root))
    val queue = collection.mutable.Queue[TreeNode](root)

    def append(node: TreeNode): Unit = if (node != null) queue.append(node)

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      val left = node.left
      val right = node.right

      result.append(asString(left))
      result.append(asString(right))

      append(left)
      append(right)
    }

    result.reverse.dropWhile(_ == NULL).reverse.mkString(",")
  }

  def deserialize(s: String): TreeNode = {
    if (s == null || s.isEmpty || s == NULL) {
      return null
    }

    val nodes = s.split(',').map(s => if (s == NULL) null else new TreeNode(s.toInt))
    val root = nodes(0)
    val queue = collection.mutable.Queue[TreeNode](root)

    def append(node: TreeNode): Unit = if (node != null) queue.append(node)

    def getNode(i: Int): TreeNode = if (i < nodes.length) nodes(i) else null

    for (i <- 1 to nodes.length by 2) {
      val target = queue.dequeue()
      val left = getNode(i)
      val right = getNode(i + 1)

      target.left = left
      target.right = right

      append(left)
      append(right)
    }

    root
  }
}

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}
