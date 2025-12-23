package ru.yandex.practicum.software_architecture.telemetry_service.adapter.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.telemetry_service.model.MessageType;
import ru.yandex.practicum.software_architecture.telemetry_service.service.TelemetryService;

@Service
@RequiredArgsConstructor
public class TelemetryEventConsumer {

    private final TelemetryService deviceService;

    @KafkaListener(topics = "my-topic-name", groupId = "my-consumer-group")
    public void consume(String message) {
        // will be implemented later to receive messages from the specified topic
        deviceService.handleMessage(MessageType.GET_TEMPERATURE, "");
    }
}
