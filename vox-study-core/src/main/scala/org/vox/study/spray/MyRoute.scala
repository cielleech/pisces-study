package org.vox.study.spray

import akka.actor.{Actor, ActorRef, ActorSystem}

class MyRoute extends App {
  val system = ActorSystem("spray-can-server")

  val listener: ActorRef = null
//  IO(Http) ! Http.Bind(listener, interface = "localhost", port = 8080)
}

class AdxActor extends Actor {
  override def receive: Receive = ???
}