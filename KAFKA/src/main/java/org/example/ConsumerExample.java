import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerExample {
    public static void main(String[] args) {
        // Kafka consumer ayarları
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // Kafka consumer nesnesi oluşturma
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList("operations"));

        while (true) {
            consumer.poll(Duration.ofMillis(100)).forEach((ConsumerRecord<String, String> record) -> {
                String message = record.value();
                System.out.println("Received message: " + message);
                // İşlem yapma (örneğin, Fibonacci ve asal sayı kontrolü)
                processMessage(message);
            });
        }
    }

    private static void processMessage(String message) {
        // Mesajı işleme ve Fibonacci, asal sayı kontrolü yapma
        // Burada JSON ayrıştırması ve işlem yapılması gerekir
        System.out.println("Processing message: " + message);
    }
}
