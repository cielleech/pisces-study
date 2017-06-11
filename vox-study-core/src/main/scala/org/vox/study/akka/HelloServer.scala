package org.vox.study.akka

import akka.actor.{ActorSystem, Props}

/**
  * Created by cielleech on 2017/6/10.
  */
object HelloServer {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloServer")
    val actor = system.actorOf(Props[HelloActor], "helloworld")
    System.out.println(actor.path)
  }
}
