package org.example.kafka.tutorial1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoCallback {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ProducerDemoCallback.class);
        System.out.println("hello world!!");

//        create the producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

//        create the producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("first_topic", "tinku world!");

//        send data
        kafkaProducer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null){
                    logger.info("Received new meta data");
                    logger.info("Topic:"+metadata.topic());
                    logger.info("Partition:"+metadata.partition());
                    logger.info("Offset:"+metadata.offset());
                    logger.info("Timestamp:"+metadata.timestamp());
                } else {
                    logger.error("Error while producing",exception);
                }
            }
        });

        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
