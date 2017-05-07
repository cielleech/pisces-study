package org.vox.study.nio

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor

object HttpAsyncClientUtils {
  def main(args: Array[String]): Unit = {
    val reactor = new DefaultConnectingIOReactor()
    val cm = new PoolingNHttpClientConnectionManager(reactor)
    val client = HttpAsyncClientBuilder.create().setConnectionManager(cm).build()
    client.start()
    val httpGet = new HttpGet("http://www.sina.com.cn")
    val future = client.execute(httpGet, null)
    println(future.get())
    client.close()
  }
}