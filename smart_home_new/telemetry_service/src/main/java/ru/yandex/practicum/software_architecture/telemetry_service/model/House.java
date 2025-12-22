package ru.yandex.practicum.software_architecture.telemetry_service.model;

import lombok.Data;

import java.util.List;

@Data
public class House {

    String id;

    String location;
    ManagingHub managingHub;

    List<TemperatureMeasurement> temperatureHistory;
    List<VideoCapture> videoSurveillanceHistory;
}
