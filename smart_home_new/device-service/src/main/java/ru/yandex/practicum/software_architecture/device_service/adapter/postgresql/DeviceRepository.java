package ru.yandex.practicum.software_architecture.device_service.adapter.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.software_architecture.device_service.adapter.postgresql.entity.SensorEntity;

@Repository
public interface DeviceRepository extends JpaRepository<SensorEntity, Long> {
}
