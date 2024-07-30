package org.example.kafkaconsumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

//KafkaConsumer то что будет принимать наши сообщения
@Service
public class KafkaConsumer {
    String kafkaResponse = "";
    // имя топика откуда будет принимать, groupId консьюмеры собираются в группы
    @KafkaListener(topics = "product-service", groupId = "myconsumer")
    public void listen(String message) {
        kafkaResponse += message;
        System.out.println("Received message: " + message);
    }




//    //Можем принять String message или ConsumerRecord<String, String> (пара ключ - тип значения)
//    public void listen(ConsumerRecord<String, String> record) {
//        record.key(); //Достаем ключ
//        record.value(); //Достаем значения
//    }
}
