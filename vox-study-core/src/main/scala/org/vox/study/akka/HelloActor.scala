package org.vox.study.akka

import akka.actor.{Actor, Props}

/**
  * Created by cielleech on 2017/6/10.
  */
class HelloActor extends Actor{
  override def preStart(): Unit = {
    val greeter = context.actorOf(Props[Greeter], "greeter")
    greeter ! Greet("start work")
  }

  override def receive: Receive = {
    case Done => println("receive done")
  }
}
