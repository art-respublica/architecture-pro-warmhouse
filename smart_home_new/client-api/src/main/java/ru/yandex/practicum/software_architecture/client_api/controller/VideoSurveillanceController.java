package ru.yandex.practicum.software_architecture.client_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.client_api.model.VideoCapture;
import ru.yandex.practicum.software_architecture.client_api.service.DeviceService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/video", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class VideoSurveillanceController {

    private final DeviceService deviceService;

    @GetMapping("/house/{houseId}/saved")
    @ResponseStatus(code = HttpStatus.OK)
    public List<VideoCapture> getTemperatureHistory(@PathVariable String houseId) {
        return deviceService.getVideoSurveillanceHistory(houseId);
    }

    @PostMapping("/{sensorId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void turnOn(@PathVariable String sensorId) {
        deviceService.turnOn(sensorId);
    }
}
