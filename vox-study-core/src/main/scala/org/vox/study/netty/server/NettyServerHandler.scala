package org.vox.study.netty.server

import io.netty.channel.{ChannelHandlerContext, SimpleChannelInboundHandler}
import io.netty.handler.codec.http.HttpObject

/**
  * Created by cielleech on 2017/6/2.
  */
class NettyServerHandler extends SimpleChannelInboundHandler[HttpObject] {
  override def channelRead0(ctx: ChannelHandlerContext, msg: HttpObject): Unit = ???
}
