package ru.yandex.practicum.software_architecture.device_service.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class Sensor {

    String id;
    String name;
    SensorType deviceType;
    String location;
    BigDecimal value;
    String unit;
    SensorStatus status;
    Instant createdAt;
    Instant updatedAt;
}
