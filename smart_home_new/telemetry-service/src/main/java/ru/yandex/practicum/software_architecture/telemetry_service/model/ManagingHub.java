package ru.yandex.practicum.software_architecture.telemetry_service.model;

import lombok.Data;

import java.util.List;

@Data
public class ManagingHub {

    String id;
    List<Sensor> sensors;
}
