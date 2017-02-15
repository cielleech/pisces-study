package org.vox.study.netty

import java.net.URI

import io.netty.bootstrap.Bootstrap
import io.netty.buffer.Unpooled
import io.netty.channel.{ChannelHandlerContext, ChannelInboundHandlerAdapter, ChannelInitializer, ChannelOption}
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.http.{DefaultFullHttpRequest, HttpContent, HttpHeaders, HttpMethod, HttpRequestEncoder, HttpResponse, HttpResponseDecoder, HttpVersion}
import io.netty.util.CharsetUtil

/**
  * @author cielleech
  */
class NettyClient {
  def connect(): Unit = {
    val group = new NioEventLoopGroup
    val bootstrap = new Bootstrap
    bootstrap.group(group).channel(classOf[NioSocketChannel]).option(ChannelOption.TCP_NODELAY, new java.lang.Boolean(true))
      .handler(new ChannelInitializer[SocketChannel]() {
        protected override def initChannel(ch: SocketChannel): Unit = {
          ch.pipeline().addLast(new HttpResponseDecoder).addLast(new HttpRequestEncoder).addLast(new HttpClientHandler)
        }
      })

    val future = bootstrap.connect("www.baidu.com", 80).sync()

    val uri = new URI("http://www.baidu.com")
    val msg = "Are you ok?";
    val request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
      uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));

    // 构建http请求
    //    request.headers().set(HttpHeaders.Names.HOST, "127.0.0.1");
    //    request.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
    //    request.headers().set(HttpHeaders.Names.CONTENT_LENGTH, request.content().readableBytes());
    // 发送http请求
    future.channel().write(request)
    future.channel().flush()
    future.channel().closeFuture().sync()
  }
}

class HttpClientHandler extends ChannelInboundHandlerAdapter {
  override def channelRead(ctx: ChannelHandlerContext, msg: Object): Unit = {
    Option(msg) match {
      case Some(response: HttpResponse) => println("CONTENT_TYPE:" + response.headers().get(HttpHeaders.Names.CONTENT_TYPE))
      case Some(content: HttpContent) =>
        println(content.content().toString(CharsetUtil.UTF_8)); content.content().release()
      case _ => None
    }
  }
}

object NettyClient {
  def main(args: Array[String]): Unit = {
    val client = new NettyClient
    client.connect()
  }
}