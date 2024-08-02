package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerExample {
    public static void main(String[] args) {
        // Kafka producer ayarları
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Kafka producer nesnesi oluşturma
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Mesaj oluşturma ve gönderme
        String topic = "operations";
        String message = "{\"operand\": 13, \"operation\": \"fibPrime\"}";
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);

        try {
            Future<RecordMetadata> future = producer.send(record);
            RecordMetadata metadata = future.get();
            System.out.println("Message sent to topic " + metadata.topic() + " partition " + metadata.partition());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
