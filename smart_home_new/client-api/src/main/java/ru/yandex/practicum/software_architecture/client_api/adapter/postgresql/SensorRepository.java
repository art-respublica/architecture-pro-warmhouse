package ru.yandex.practicum.software_architecture.client_api.adapter.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.entity.SensorEntity;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {

}
