package ru.yandex.practicum.software_architecture.client_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.SensorRepository;
import ru.yandex.practicum.software_architecture.client_api.adapter.smarthome.SmartHomeAdapter;
import ru.yandex.practicum.software_architecture.client_api.model.TemperatureMeasurement;
import ru.yandex.practicum.software_architecture.client_api.model.VideoCapture;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final SensorRepository sensorRepository;
    private final SmartHomeAdapter smartHomeAdapter;

    public List<TemperatureMeasurement> getTemperatureHistory(String houseId) {
        return smartHomeAdapter.getTemperatureHistory(houseId);
    }

    public List<VideoCapture> getVideoSurveillanceHistory(String houseId) {
        return smartHomeAdapter.getVideoSurveillanceHistory(houseId);
    }

    public void turnOn(String sensorId) {
        smartHomeAdapter.turnOn(sensorId);
    }
}
