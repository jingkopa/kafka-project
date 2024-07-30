package org.example.productservice.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic newTopic() {
        //Партиции нужны для сохранности данных и паралеллизации данных, для ускорения работы брокера сообщения.
        // Партиции хранят копии сообщений в порядке потока.
        //Лидер партиции и тд
        //Возвращаем новый топик с параметрами: имя, количеством партиций и replication factor 1.
        return new NewTopic("product-service", 1, (short) 1);
    }
}