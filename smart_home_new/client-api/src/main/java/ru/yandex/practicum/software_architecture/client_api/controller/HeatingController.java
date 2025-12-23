package ru.yandex.practicum.software_architecture.client_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.client_api.model.TemperatureMeasurement;
import ru.yandex.practicum.software_architecture.client_api.service.DeviceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/temperature", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class HeatingController {

    private final DeviceService deviceService;

    @GetMapping("/house/{houseId}/saved")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TemperatureMeasurement> getTemperatureHistory(@PathVariable String houseId) {
        return deviceService.getTemperatureHistory(houseId);
    }

    @PostMapping("/{sensorId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void turnOn(@PathVariable String sensorId) {
        deviceService.turnOn(sensorId);
    }
}
