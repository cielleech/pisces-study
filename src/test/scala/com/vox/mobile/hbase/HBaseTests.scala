package com.vox.mobile.hbase

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.Connection
import org.apache.hadoop.hbase.client.ConnectionFactory
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory
import org.apache.hadoop.hbase.TableName

class HBaseTests {
  import HBaseTests.logger
  
  private val conf = HBaseConfiguration.create()
  
  private var connection: Connection = null
  
  @Before
  def setup(): Unit = {
    conf.set("hbase.zookeeper.property.clientPort", "2181")
    conf.set("hbase.zookeeper.quorum", "10.198.184.190")
    connection = ConnectionFactory.createConnection(conf)    
  }
  
  @Test
  def createTableTest(): Unit = {
    val admin = connection.getAdmin;
    
    logger.info("exists: " + admin.tableExists(TableName.valueOf("opview:tsdb")))
  }
}

object HBaseTests {
  private val logger = LoggerFactory.getLogger(classOf[HBaseTests])
}