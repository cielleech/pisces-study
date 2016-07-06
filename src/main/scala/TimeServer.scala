package  org.pisces.study.netty

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.Unpooled

/**
  * Created by cielleech on 16/7/4.
  */
class TimeServer {

}

object TimeServer {
  def main(args: Array[String]): Unit = {
    val buffer = Unpooled.buffer(16)

    for(i <- 0 until 16) {
      buffer.writeByte(i + 10)
    }

    ServerBootstrap
  }
}
