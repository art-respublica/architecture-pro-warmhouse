package ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "houses")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class HouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    String id;
}
