package com.example.demo.kafkalog;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.Layout;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Properties;

public class KafkaAppender<E> extends AppenderBase<E> {

    private String topic;
    private String zookeeperHost;
    private Producer<String, String> producer;
    private Formatter formatter;
    private String brokerList;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getZookeeperHost() {
        return zookeeperHost;
    }

    public void setZookeeperHost(String zookeeperHost) {
        this.zookeeperHost = zookeeperHost;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public String getBrokerList() {
        return brokerList;
    }

    public void setBrokerList(String brokerList) {
        this.brokerList = brokerList;
    }


    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void start() {




    }

    @Override
    public void stop() {


    }



    public void append(ILoggingEvent event) {
        String payload = this.formatter.format(event);
        kafkaTemplate.send("sparklogTest", payload);
    }
    protected Layout<E> layout;

    public Layout<E> getLayout() {
        return layout;
    }

    public void setLayout(Layout<E> layout) {
        this.layout = layout;
    }

    @Override
    protected void append(E e) {
        String payload = this.formatter.format((ILoggingEvent)e);
        kafkaTemplate.send("sparklogTest", payload);

    }
}
