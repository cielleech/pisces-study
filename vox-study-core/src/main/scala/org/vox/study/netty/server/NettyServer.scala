package org.vox.study.netty.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.{Channel, ChannelInitializer}

/**
  * Created by cielleech on 2017/5/28.
  */
class NettyServer {
  def init(): Unit = {
    val bootstrap = new ServerBootstrap()
    val bossGroup = new NioEventLoopGroup()
    val workGroup = new NioEventLoopGroup()
    bootstrap.group(bossGroup, workGroup).childHandler(new ChannelInitializer[Channel] {
      override def initChannel(ch: Channel): Unit = {
        ch.pipeline()
      }
    })

    bootstrap.bind(8080).sync()
  }
}
