package org.tyrant.study.structure

/**
  * Created by cielleech on 2017/3/12.
  */
class TreeNode[K <: Comparable[K], V](val key: K, val value: V) {
  var left: TreeNode[K, V] = _

  var right: TreeNode[K, V] = _

  var parent: TreeNode[K, V] = _
}

class Tree[K <: Comparable[K], V] {
  var root: TreeNode[K, V] = _
  def preorder(): Unit = {
    val z: TreeNode[K, V] = root
    preorder(z)
  }


  private def preorder(node: TreeNode[K, V]): Unit = {
    while(true) {
      run(node)
      if (node.left != null) {
        preorder(node.left)
      }

      if (node.right != null) {
        preorder(node.right)
      }
    }
  }

  private def run(node: TreeNode[K, V]): Unit = {
    println(node.value)
  }
}
