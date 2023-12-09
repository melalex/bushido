package com.leetcode

object BinaryTreeRightSideView {

  def rightSideView(root: TreeNode): List[Int] = {
    val listBuilder = List.newBuilder[Int]

    def loop(node: TreeNode, level: Int, maxLevel: Int): Int =
      if (node == null) math.max(level, maxLevel)
      else {
        var newMax = if (level > maxLevel) {
          listBuilder.addOne(node.value)
          level
        } else maxLevel

        newMax = loop(node.right, level + 1, newMax)

        math.max(newMax, loop(node.left, level + 1, newMax))
      }

    loop(root, 0, -1)

    listBuilder.result()
  }
}
