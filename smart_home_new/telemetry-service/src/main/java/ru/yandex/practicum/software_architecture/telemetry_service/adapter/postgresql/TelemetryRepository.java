package ru.yandex.practicum.software_architecture.telemetry_service.adapter.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.practicum.software_architecture.telemetry_service.adapter.postgresql.entity.SensorEntity;

@Repository
public interface TelemetryRepository extends JpaRepository<SensorEntity, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO temperatury_history(message) VALUES (:message)", nativeQuery = true)
    void saveTemperatureMeasure(String message);
}
