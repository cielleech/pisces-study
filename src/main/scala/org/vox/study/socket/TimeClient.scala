package org.vox.study.socket

import java.io.{BufferedReader, InputStreamReader}
import java.net.Socket

object TimeClient {
  def main(args: Array[String]): Unit = {
    val socket = new Socket("127.0.0.1", 8080)
    val br = new BufferedReader(new InputStreamReader(socket.getInputStream))
    val txt = br.readLine()
    println(txt)
    br.close()
    socket.close()
  }
}