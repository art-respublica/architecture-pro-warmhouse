package ru.yandex.practicum.software_architecture.device_service.adapter.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.device_service.model.MessageType;
import ru.yandex.practicum.software_architecture.device_service.service.DeviceService;

@Service
@RequiredArgsConstructor
public class DeviceEventConsumer {

    private final DeviceService deviceService;

    @KafkaListener(topics = "my-topic-name", groupId = "my-consumer-group")
    public void consume(String message) {
        // will be implemented later to receive messages from the specified topic
        deviceService.handleMessage(MessageType.TURN_ON_HEATING, "");
    }
}
