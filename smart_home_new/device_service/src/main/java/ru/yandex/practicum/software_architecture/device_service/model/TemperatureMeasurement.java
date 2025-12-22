package ru.yandex.practicum.software_architecture.device_service.model;

import lombok.Data;

import java.time.Instant;

@Data
public class TemperatureMeasurement {

    Instant measuredAt;
    String value;
    String sensorId;
}
