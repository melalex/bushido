package com.leetcode

object NumberOfIslands {

  val WATER = '0'
  val LAND = '1'
  val VISITED_LAND = '2'

  def numIslands(sea: Array[Array[Char]]): Int = {

    def getNextLand: Option[(Int, Int)] = (
      for {
        y <- sea.indices
        x <- sea(y).indices
        if sea(y)(x) == LAND
      } yield (x, y)
      ).headOption

    def visit(x: Int, y: Int): Unit = getVal(x, y) match {
      case LAND =>
        sea(y)(x) = VISITED_LAND
        visit(x - 1, y)
        visit(x + 1, y)
        visit(x, y - 1)
        visit(x, y + 1)
      case _ =>
    }

    def getVal(x: Int, y: Int): Char =
      if (y < 0 || y >= sea.length || x < 0 || (y < sea.length && sea(y).length <= x)) WATER
      else sea(y)(x)

    @scala.annotation.tailrec
    def iter(option: Option[(Int, Int)], acc: Int): Int = option match {
      case Some((x, y)) =>
        visit(x, y)
        iter(getNextLand, acc + 1)
      case None => acc
    }

    var i = 0

    iter(getNextLand, 0)
  }
}
