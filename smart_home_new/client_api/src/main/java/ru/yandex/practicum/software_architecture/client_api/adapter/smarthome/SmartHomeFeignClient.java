package ru.yandex.practicum.software_architecture.client_api.adapter.smarthome;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.client_api.model.Sensor;
import ru.yandex.practicum.software_architecture.client_api.model.TemperatureMeasurement;
import ru.yandex.practicum.software_architecture.client_api.model.User;
import ru.yandex.practicum.software_architecture.client_api.model.VideoCapture;

import java.util.List;

@FeignClient(name = "smart-home-service", url = "https://localhost:9090")
public interface SmartHomeFeignClient {

    @GetMapping("/sensors")
    List<Sensor> getSensors();

    @GetMapping("/sensors/{id}")
    Sensor getResourceById(@PathVariable("id") Long id);

    @PostMapping("/sensors")
    Sensor createSensor(@RequestBody Sensor sensor);

    @PutMapping("/sensors/{id}")
    Sensor updateSensor(@PathVariable("id") Long id, @RequestBody Sensor sensor);

    @DeleteMapping("/sensors/{id}")
    Sensor deleteSensor(@PathVariable("id") Long id);

    @PatchMapping("/sensors/{id}/value")
    Void updateSensorValue(@PathVariable("id") Long id, @RequestBody String value);

    @GetMapping("/sensors/temperature/:location")
    List<TemperatureMeasurement> getTemperatureByLocation(@PathVariable("location") String location);

    @GetMapping("/sensors/video/:location")
    List<VideoCapture> getVideoCaptureByLocation(@PathVariable("location") String location);

    @GetMapping("/users/{id}")
    Sensor getUserById(@PathVariable("id") Long id);

    @SuppressWarnings("UnusedReturnValue")
    @PostMapping("/users")
    Sensor createUser(@RequestBody User user);

    @PutMapping("/users/{id}")
    Sensor updateUser(@PathVariable("id") Long id, @RequestBody User user);

    @DeleteMapping("/users/{id}")
    Sensor deleteUser(@PathVariable("id") Long id);
}
