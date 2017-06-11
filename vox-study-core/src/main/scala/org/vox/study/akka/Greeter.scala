package org.vox.study.akka

import akka.actor.Actor

/**
  * Created by cielleech on 2017/6/10.
  */
class Greeter extends Actor {
  override def receive: Receive = {
    case Greet(msg) =>
      println(msg)
      sender ! Done
  }
}

case class Greet(msg: String)
case object Done
