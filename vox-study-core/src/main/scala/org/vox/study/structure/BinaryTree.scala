package org.vox.study.structure

class BinaryTree[T <: Comparable[T]] {
  private var root: BinaryNode[T] = _

  def insert(value: T): Unit = {
    if (root == null) {
      root = new BinaryNode[T](value)
    } else {
      insert(value, root)
    }
  }

  private def insert(value: T, current: BinaryNode[T]): Unit = {
    if (current.value.compareTo(value) > 0) {
      if (current.hasLeftChild()) {
        insert(value, current.leftChild)
      } else {
        val leftChild = new BinaryNode[T](value)
        current.leftChild = leftChild
      }
    } else if (current.value.compareTo(value) < 0) {
      if (current.hasRightChild()) {
        insert(value, current.rightChild)
      } else {
        val rightChild = new BinaryNode[T](value)
        current.rightChild = rightChild
      }
    }
  }
}

class BinaryNode[T](val value: T) {
  var parent: BinaryNode[T] = _

  var leftChild: BinaryNode[T] = _

  var rightChild: BinaryNode[T] = _

  def hasLeftChild(): Boolean = {
    if (leftChild != null) true else false
  }

  def hasRightChild(): Boolean = {
    if (rightChild != null) true else false
  }
}

object BinaryTreeTests {
  def main(args: Array[String]): Unit = {
    val arrays = Array(3, 2, 1, 4, 5)
    val tree = new BinaryTree[java.lang.Integer]
    arrays.foreach(x => tree.insert(x))

    println(tree)
  }
}
