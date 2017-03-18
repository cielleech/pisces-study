package org.tyrant.study.sort

import scala.util.Random
import scala.collection.mutable.ListBuffer

class BubbleSort(n: Int) {
  val numbers = ListBuffer.tabulate(n)(_ => Random.nextInt(100000))

  def sort(): Unit = {
    println(numbers)

    for (i <- (n - 1) to 1 by -1) {
      var j = i
      while (j > 0) {
        if (numbers(j - 1) > numbers(j)) {
          val temp = numbers(j)
          numbers(j) = numbers(j - 1)
          numbers(j - 1) = temp
        }
        j = j - 1
      }
    }

    println(numbers)
  }
}

object BubbleSort {
  def main(args: Array[String]): Unit = {
    val sort = new BubbleSort(10000)
    sort.sort()
  }
}