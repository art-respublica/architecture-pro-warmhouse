package ru.yandex.practicum.software_architecture.device_service.adapter.smarthome;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.device_service.model.Sensor;
import ru.yandex.practicum.software_architecture.device_service.model.TemperatureMeasurement;
import ru.yandex.practicum.software_architecture.device_service.model.VideoCapture;

import java.util.List;

@FeignClient(name = "smart-home-service", url = "https://localhost:9090")
public interface SmartHomeFeignClient {

    @GetMapping("/sensors")
    List<Sensor> getSensors();

    @GetMapping("/sensors/{id}")
    Sensor getResourceById(@PathVariable("id") String id);

    @PostMapping("/sensors")
    Sensor createSensor(@RequestBody Sensor sensor);

    @PutMapping("/sensors/{id}")
    Sensor updateSensor(@PathVariable("id") String id, @RequestBody Sensor sensor);

    @DeleteMapping("/sensors/{id}")
    Sensor deleteSensor(@PathVariable("id") String id);

    @PatchMapping("/sensors/{id}/value")
    Void updateSensorValue(@PathVariable("id") String id, @RequestBody String value);

    @GetMapping("/sensors/temperature/:location")
    List<TemperatureMeasurement> getTemperatureByLocation(@PathVariable("location") String location);

    @GetMapping("/sensors/video/:location")
    List<VideoCapture> getVideoCaptureByLocation(@PathVariable("location") String location);
}
