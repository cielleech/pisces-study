package org.vox.study.akka.lifecycle

import akka.actor.{Actor, ActorRef, ActorSystem, PoisonPill, Props, Terminated}
import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by cielleech on 2017/6/11.
  */
class MyWork extends Actor {
  import MyWork.logger

  override def preStart(): Unit = {
    logger.error("work start")
  }

  override def postStop(): Unit = {
    logger.info("work stop")
  }

  override def receive: Receive = {
    case Working => logger.info("working")
    case Done => logger.info("work done")
    case Close => logger.info("work close")
      sender ! Close
      context.stop(self)
  }
}

object MyWork {
  val logger: Logger = LoggerFactory.getLogger(classOf[MyWork])
}

class WatchActor extends Actor {
  import WatchActor.logger

  def this(actor: ActorRef) = {
    this
    context.watch(actor)
  }
  override def receive: Receive = {
    case terminated: Terminated => logger.error(terminated.getActor.path + " has terminated, now shutdown the system")
      context.system.terminate()
  }
}

object WatchActor {
  val logger: Logger = LoggerFactory.getLogger(classOf[WatchActor])
}

case object Working
case object Done
case object Close

object Main {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("LifeCycle")
    val worker = system.actorOf(Props[MyWork], "MyWork")
    val wather = system.actorOf(Props[WatchActor], "Watcher")
    worker ! Working
    worker ! Done

    worker ! PoisonPill
  }
}