package ru.yandex.practicum.software_architecture.client_api.adapter.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.entity.SensorEntity;
import ru.yandex.practicum.software_architecture.client_api.model.TemperatureMeasurement;
import ru.yandex.practicum.software_architecture.client_api.model.VideoCapture;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, String> {

}
