package org.tyrant.study.structure

class Vector[T] {
  import Vector.DEFAULT_CAPACITY

  var size: Int = 0

  var capacity: Int = 0

  var elements: Array[T] = _

  def expand(): Unit = {
//    if (size < capacity)
//      return
//
//    if (capacity < DEFAULT_CAPACITY)
//      capacity = DEFAULT_CAPACITY
//
//    val temp = new Array[T](capacity)
//    elements.copyToArray(temp)
//    elements = temp
  }
}

object Vector {
  val DEFAULT_CAPACITY: Int = 2000
}