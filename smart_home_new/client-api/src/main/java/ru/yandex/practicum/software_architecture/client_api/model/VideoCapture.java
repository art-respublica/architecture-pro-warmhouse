package ru.yandex.practicum.software_architecture.client_api.model;

import lombok.Data;

import java.time.Instant;

@Data
public class VideoCapture {

    Instant measuredAt;
    String data;
    String sensorId;
}
