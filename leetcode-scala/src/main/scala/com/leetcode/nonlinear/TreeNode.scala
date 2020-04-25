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

  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    val inorderMap = inorder.zipWithIndex.toMap

    def construct(preStart: Int, preEnd: Int, inStart: Int, inEnd: Int): TreeNode =
      if (preStart > preEnd || inStart > inEnd) null
      else {
        val preIndex = preorder(preStart)
        val node = new TreeNode(preIndex)
        val inIndex = inorderMap(preIndex)

        node.left = construct(preStart + 1, preStart + (inIndex - inStart), inStart, inIndex - 1)
        node.right = construct(preStart + (inIndex - inStart) + 1, preEnd, inIndex + 1, inEnd)

        node
      }

    construct(0, preorder.length - 1, 0, inorder.length - 1)
  }

  def maxPathSum(root: TreeNode): Integer = {
    if (root == null) {
      return 0
    }

    var max = root.value

    @inline
    def max3(a: Int, b: Int, c: Int): Int = Math.max(Math.max(a, b), c)

    @inline
    def max5(a: Int, b: Int, c: Int, d: Int, e: Int): Int = Math.max(Math.max(Math.max(Math.max(a, b), c), d), e)

    def calculateMax(node: TreeNode): Int =
      if (node == null) 0
      else {
        val left = calculateMax(node.left)
        val right = calculateMax(node.right)

        max = max5(max, left + right + node.value, left + node.value, right + node.value, node.value)

        max3(left + node.value, right + node.value, node.value)
      }

    calculateMax(root)

    max
  }

  def maxDepth(root: TreeNode): Int = {
    def dfs(node: TreeNode, depth: Int): Int =
      if (node == null) depth
      else {
        val left = dfs(node.left, depth + 1)
        val right = dfs(node.right, depth + 1)

        Math.max(left, right)
      }

    dfs(root, 0)
  }
}

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}
