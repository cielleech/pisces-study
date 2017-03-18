package org.tyrant.study.structure

/**
  *
  * @param key
  * @param value
  * @tparam K
  * @tparam V
  */
class TreeNode[K <: Comparable[K], V](var key: K, var value: V, color: ColorEnum.Value) {
  var left: TreeNode[K, V] = _

  var right: TreeNode[K, V] = _

  var parent: TreeNode[K, V] = _
}

class RedBlackTree[K <: Comparable[K], V] {
  var root: TreeNode[K, V] = _

  def insert(key: K, value: V): Unit = {
    if (root == null)
      root = new TreeNode(key, value, ColorEnum.BLACK)
    else {
      var cur = root
      while(true) {
        if (key.compareTo(cur.key) < 0) {
          cur = cur.left
        } else if (key.compareTo(cur.key) > 0) {
          cur = cur.left
        } else {
          val node = new TreeNode(key, value, ColorEnum.BLACK)
          node.left = cur.left
          node.right = cur.right
          node.parent = cur.parent
        }
      }
    }
  }
}

object ColorEnum extends Enumeration {
  type ColorEnum = Value

  val RED = Value("red")
  val BLACK = Value("black")
}

object AppMananger extends App {
  val red = ColorEnum.BLACK
}
