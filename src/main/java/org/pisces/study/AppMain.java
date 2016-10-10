package org.pisces.study;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.kafka.*;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;
import org.pisces.study.storm.KafkaWordSplitter;
import org.pisces.study.storm.WordCounter;

import java.util.Collections;

/**
 * Created by cielleech on 16/8/20.
 */
public class AppMain {
    public static void main(String[] args) throws InterruptedException {
        String zks = "127.0.0.1:12181";
        String topic = "my-replicated-topic";
        String zkRoot = "/storm";
        String id = "word";

        BrokerHosts brokerHosts = new ZkHosts(zks);
        SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, topic, zkRoot, id);

        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        spoutConfig.zkServers = Collections.singletonList("127.0.0.1");
        spoutConfig.zkPort = 12181;
        // 设置赛马zk
        // SpoutConfig spoutConfig = new SpoutConfig(new ZkHosts("10.201.47.107,10.201.47.108,10.201.47.109", "/vms_pvuv/brokers"), "default_channel_kdt_app_others", "/spec", "spec_others_01");
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("kafka-reader", new KafkaSpout(spoutConfig), 1);
        builder.setBolt("word-splitter", new KafkaWordSplitter(), 2).shuffleGrouping("kafka-reader");
        builder.setBolt("word-counter", new WordCounter(), 2).fieldsGrouping("word-splitter", new Fields("word"));//.shuffleGrouping("kafka-reader");

        Config config = new Config();
        String name = AppMain.class.getSimpleName();
        config.setMaxTaskParallelism(1);
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology(name, config, builder.createTopology());
        Thread.sleep(10000000);
        cluster.shutdown();
    }
}
