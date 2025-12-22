package ru.yandex.practicum.software_architecture.client_api.adapter.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC_NAME = "your-topic-name"; // Define your topic name

    public void sendMessage(String message) {
        // will be implemented later to send message to the specified topic
        kafkaTemplate.send(TOPIC_NAME, message);
    }
}
