package org.vox.study.reflection

import org.vox.study.domain.Dog

/**
 * 
 * @author cielleech
 * 
 */
object AppMain {
  def main(args: Array[String]): Unit = {
    val dog = classOf[Dog].getConstructor(classOf[String]).newInstance("小宝")
    val fields = classOf[Dog].getFields
  }
}