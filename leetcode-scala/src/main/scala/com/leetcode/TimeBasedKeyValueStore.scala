package com.leetcode

class TimeBasedKeyValueStore {

  private val map = scala.collection.mutable.Map[String, scala.collection.mutable.TreeMap[Int, String]]()

  def set(key: String, value: String, timestamp: Int): Unit = {
    val inner = map.getOrElseUpdate(key, scala.collection.mutable.TreeMap[Int, String]())

    inner.put(timestamp, value)
  }

  def get(key: String, timestamp: Int): String = {
    val inner = map.getOrElseUpdate(key, scala.collection.mutable.TreeMap[Int, String]())

    inner.rangeTo(timestamp).lastOption.map(_._2).getOrElse("")
  }
}
