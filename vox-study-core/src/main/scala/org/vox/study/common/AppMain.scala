package org.vox.study.common

import com.google.common.cache.CacheBuilder

/**
  * Created by cielleech on 16/6/28.
  */
object AppMain {
  def main(args: Array[String]): Unit = {
    CacheBuilder.newBuilder()
    println("Hello World!")
  }
}
