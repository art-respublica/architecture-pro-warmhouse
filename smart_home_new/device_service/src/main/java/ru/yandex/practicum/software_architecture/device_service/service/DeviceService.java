package ru.yandex.practicum.software_architecture.device_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.device_service.adapter.postgresql.DeviceRepository;
import ru.yandex.practicum.software_architecture.device_service.adapter.smarthome.SmartHomeAdapter;
import ru.yandex.practicum.software_architecture.device_service.model.MessageType;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final SmartHomeAdapter smartHomeAdapter;
    private final DeviceRepository deviceRepository;

    public void handleMessage(MessageType messageType, String message) {
        switch (messageType) {
            case TURN_OFF_GATE -> smartHomeAdapter.turnOffGate();
            case TURN_OFF_HEATING -> smartHomeAdapter.turnOffHeating();
            case TURN_OFF_LIGHTING -> smartHomeAdapter.turnOffLighting();
            case TURN_OFF_VIDEO -> smartHomeAdapter.turnOffVideo();
            case TURN_ON_GATE -> smartHomeAdapter.turnOnGate();
            case TURN_ON_HEATING -> smartHomeAdapter.turnOnHeating();
            case TURN_ON_LIGHTING -> smartHomeAdapter.turnOnLighting();
            case TURN_ON_VIDEO -> smartHomeAdapter.turnOnVideo();
            default -> { /* Сообщение не обрабатывается */ }
        }
    }
}
