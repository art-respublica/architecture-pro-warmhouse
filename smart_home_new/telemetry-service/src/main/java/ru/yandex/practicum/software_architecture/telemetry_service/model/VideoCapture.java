package ru.yandex.practicum.software_architecture.telemetry_service.model;

import lombok.Data;

import java.time.Instant;

@Data
public class VideoCapture {

    Instant measuredAt;
    String data;
    String sensorId;
}
