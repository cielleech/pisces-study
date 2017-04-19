package org.tyrant.study.kafka

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}

/**
  * Created by cielleech on 2017/4/10.
  */
object MessageProducer extends App {
  val props = new Properties()

  props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092")
  props.put(ProducerConfig.ACKS_CONFIG, "0")
  props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
  props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[Nothing, String](props)

  val record = new ProducerRecord[Nothing, String]("test", s"Hello world!")
  producer.send(record)
  producer.close()
}
