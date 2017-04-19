package org.tyrant.study.socket

import java.io.PrintStream
import java.net.ServerSocket

/**
  * Created by cielleech on 2017/2/13.
  */
object TimeServer {
  def main(args: Array[String]): Unit = {
    val ss = new ServerSocket(8080)
    while(true) {
      val socket = ss.accept()
      val ps = new PrintStream(socket.getOutputStream)
      ps.println("Hello, Client!")
      ps.close()
      socket.close()
    }
  }
}
