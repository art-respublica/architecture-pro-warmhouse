package ru.yandex.practicum.software_architecture.client_api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
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
