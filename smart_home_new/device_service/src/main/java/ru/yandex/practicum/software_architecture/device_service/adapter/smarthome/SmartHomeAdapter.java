package ru.yandex.practicum.software_architecture.device_service.adapter.smarthome;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmartHomeAdapter {

    private final SmartHomeFeignClient feignClient;

    public void turnOffGate(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }

    public void turnOffHeating(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }

    public void turnOffLighting(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }

    public void turnOffVideo(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }

    public void turnOnGate(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }

    public void turnOnHeating(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }

    public void turnOnLighting(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }

    public void turnOnVideo(String sensorId, Sensor sensor) {
        feignClient.updateSensor(sensorId, sensor);
    }
}
