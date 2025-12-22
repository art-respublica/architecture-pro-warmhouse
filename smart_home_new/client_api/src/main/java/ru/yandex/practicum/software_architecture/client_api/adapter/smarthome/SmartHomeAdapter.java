package ru.yandex.practicum.software_architecture.client_api.adapter.smarthome;

import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.client_api.model.Sensor;
import ru.yandex.practicum.software_architecture.client_api.model.TemperatureMeasurement;
import ru.yandex.practicum.software_architecture.client_api.model.User;
import ru.yandex.practicum.software_architecture.client_api.model.VideoCapture;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmartHomeAdapter {

    private final SmartHomeFeignClient feignClient;

    public List<TemperatureMeasurement> getTemperatureHistory(String houseId) {
        return feignClient.getTemperatureByLocation(houseId);
    }

    public List<VideoCapture> getVideoSurveillanceHistory(String houseId) {
        return feignClient.getVideoCaptureByLocation(houseId);
    }

    public void saveUser(User user) {
        feignClient.createUser(user);
    }

    public void saveSensor(Sensor sensor) {
        feignClient.createSensor(sensor);
    }

    public void turnOn(String sensorId) {
        // turn on sensor in Smart Home (previous edition);
    }
}
