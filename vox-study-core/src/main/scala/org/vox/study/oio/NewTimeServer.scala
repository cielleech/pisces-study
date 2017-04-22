package org.vox.study.oio

import java.net.ServerSocket
import java.util.concurrent.Executors

import org.apache.commons.lang.math.NumberUtils
import org.tyrant.study.oio.server.TimeServerHandler

/**
  * Created by cielleech on 2017/4/19.
  */
object NewTimeServer {
  def main(args: Array[String]): Unit = {
    val port = NumberUtils.toInt(args(0), 8080)
    var server: ServerSocket = null
    try {
      server = new ServerSocket(port)
      println("The time server is start in port:" + port)
      val service = Executors.newFixedThreadPool(50)
      while (true) {
        val socket = server.accept()
        service.submit(new TimeServerHandler(socket))
      }
    } finally {
      if (server != null) {
        println("The time server close")
        server.close()
        server = null
      }
    }
  }
}
