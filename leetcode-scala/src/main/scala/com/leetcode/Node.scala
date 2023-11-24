package com.leetcode

object Node {

  def cloneGraph(graph: Node): Node = {
    if (graph == null) {
      return null
    }

    val nodes = collection.mutable.Map[Node, Node]()

    def clone(node: Node): Node =
      if (nodes.contains(node)) nodes(node)
      else {
        val copy = new Node(node.value)

        nodes(node) = copy

        copy.neighbors = node.neighbors.map(clone)

        copy
      }

    clone(graph)
  }
}

class Node(var _value: Int) {
  var value: Int = _value
  var neighbors: List[Node] = List()
}
