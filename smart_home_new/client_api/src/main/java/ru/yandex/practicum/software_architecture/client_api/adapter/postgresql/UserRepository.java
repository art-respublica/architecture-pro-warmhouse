package ru.yandex.practicum.software_architecture.client_api.adapter.postgresql;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findById(String username);
}
