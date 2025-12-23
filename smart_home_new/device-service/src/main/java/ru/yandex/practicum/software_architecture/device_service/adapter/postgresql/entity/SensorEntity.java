package ru.yandex.practicum.software_architecture.device_service.adapter.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.yandex.practicum.software_architecture.device_service.model.SensorStatus;
import ru.yandex.practicum.software_architecture.device_service.model.SensorType;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "sensors")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "sensor_name")
    String name;

    @Column(name = "device_type")
    @Enumerated(EnumType.STRING)
    SensorType deviceType;

    @Column(name = "location")
    String location;

    @Column(name = "sensor_value")
    BigDecimal value;

    @Column(name = "unit")
    String unit;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    SensorStatus status;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    Instant updatedAt;
}
