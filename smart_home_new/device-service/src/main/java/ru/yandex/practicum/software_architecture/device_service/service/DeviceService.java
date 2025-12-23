package ru.yandex.practicum.software_architecture.device_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.device_service.adapter.postgresql.DeviceRepository;
import ru.yandex.practicum.software_architecture.device_service.adapter.postgresql.entity.SensorEntity;
import ru.yandex.practicum.software_architecture.device_service.adapter.smarthome.SmartHomeAdapter;
import ru.yandex.practicum.software_architecture.device_service.model.MessageType;
import ru.yandex.practicum.software_architecture.device_service.model.Sensor;
import ru.yandex.practicum.software_architecture.device_service.model.SensorStatus;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final SmartHomeAdapter smartHomeAdapter;
    private final DeviceRepository deviceRepository;

    public void handleMessage(MessageType messageType, String sensorId) {
        Optional<SensorEntity> optional = deviceRepository.findById(Long.valueOf(sensorId));
        if (optional.isEmpty()) {
            return;
        }
        Sensor sensor = convertToSensor(optional.get());

        switch (messageType) {
            case TURN_OFF_GATE -> smartHomeAdapter.turnOffGate(sensorId,
                    sensor.toBuilder().status(SensorStatus.IDLE).build());
            case TURN_OFF_HEATING -> smartHomeAdapter.turnOffHeating(sensorId,
                    sensor.toBuilder().status(SensorStatus.IDLE).build());
            case TURN_OFF_LIGHTING -> smartHomeAdapter.turnOffLighting(sensorId,
                    sensor.toBuilder().status(SensorStatus.IDLE).build());
            case TURN_OFF_VIDEO -> smartHomeAdapter.turnOffVideo(sensorId,
                    sensor.toBuilder().status(SensorStatus.IDLE).build());
            case TURN_ON_GATE -> smartHomeAdapter.turnOnGate(sensorId,
                    sensor.toBuilder().status(SensorStatus.WORKING).build());
            case TURN_ON_HEATING -> smartHomeAdapter.turnOnHeating(sensorId,
                    sensor.toBuilder().status(SensorStatus.WORKING).build());
            case TURN_ON_LIGHTING -> smartHomeAdapter.turnOnLighting(sensorId,
                    sensor.toBuilder().status(SensorStatus.WORKING).build());
            case TURN_ON_VIDEO -> smartHomeAdapter.turnOnVideo(sensorId,
                    sensor.toBuilder().status(SensorStatus.WORKING).build());
            default -> { /* Сообщение не обрабатывается */ }
        }
    }

    private Sensor convertToSensor(SensorEntity sensorEntity) {
        return Sensor.builder()
                .id(sensorEntity.getId().toString())
                .build();
    }
}
