package ru.yandex.practicum.software_architecture.client_api.model;

import lombok.Data;

import java.util.List;

@Data
public class ManagingHub {

    String id;
    List<Sensor> sensors;
}
