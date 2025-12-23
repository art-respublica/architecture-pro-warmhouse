package ru.yandex.practicum.software_architecture.telemetry_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.telemetry_service.adapter.postgresql.TelemetryRepository;
import ru.yandex.practicum.software_architecture.telemetry_service.model.MessageType;

@Service
@RequiredArgsConstructor
public class TelemetryService {

    private final TelemetryRepository telemetryRepository;

    public void handleMessage(MessageType messageType, String message) {
        switch (messageType) {
            case GET_TEMPERATURE -> telemetryRepository.saveTemperatureMeasure(message);
            default -> { /* Сообщение не обрабатывается */ }
        }
    }
}
