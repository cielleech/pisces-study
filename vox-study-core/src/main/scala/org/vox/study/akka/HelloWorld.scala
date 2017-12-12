package org.vox.study.akka

import akka.actor.{Actor, ActorSystem, Props}

class HelloWorld extends Actor {
  override def receive: Receive = {
    case "hello" => println("hello back to you")
  }
}

object HelloWorldApp extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloWorld], "helloActor")

  helloActor ! "hello"
  system.shutdown()
}