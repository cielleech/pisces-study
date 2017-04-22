package org.vox.study.util

import org.apache.storm.shade.org.apache.http.config.RegistryBuilder
import org.apache.storm.shade.org.apache.http.conn.socket.{ConnectionSocketFactory, PlainConnectionSocketFactory}
import org.apache.storm.shade.org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.storm.shade.org.apache.http.impl.client.{CloseableHttpClient, HttpClients}
import org.apache.storm.shade.org.apache.http.impl.conn.PoolingHttpClientConnectionManager

object HttpClientUtils {
  val client = {
    val csf = PlainConnectionSocketFactory.getSocketFactory
    val lcsf = SSLConnectionSocketFactory.getSocketFactory
    val registry = RegistryBuilder.create[ConnectionSocketFactory]().register("http", csf).register("https", lcsf).build()
    val cm = new PoolingHttpClientConnectionManager(registry)
    cm.setMaxTotal(200)
    cm.setDefaultMaxPerRoute(10)

    val client = HttpClients.custom()
    .setConnectionManager(cm).build()
  }

  def get(url: String): String = {
    ""
  }
}