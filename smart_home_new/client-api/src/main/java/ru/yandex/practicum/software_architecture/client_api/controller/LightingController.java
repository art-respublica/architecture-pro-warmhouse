package ru.yandex.practicum.software_architecture.client_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.client_api.service.DeviceService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/lighting", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class LightingController {

    private final DeviceService deviceService;

    @PostMapping("/{sensorId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void turnOn(@PathVariable String sensorId) {
        deviceService.turnOn(sensorId);
    }
}
