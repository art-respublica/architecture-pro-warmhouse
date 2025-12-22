package ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.yandex.practicum.software_architecture.client_api.model.House;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "agreementId")
    private String agreementId;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<HouseEntity> houses;
}
