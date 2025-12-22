package ru.yandex.practicum.software_architecture.client_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.UserRepository;
import ru.yandex.practicum.software_architecture.client_api.adapter.postgresql.entity.UserEntity;
import ru.yandex.practicum.software_architecture.client_api.model.User;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository repository;

    public void loginUser(String username, String password) {
        Optional<UserEntity> optional = repository.findById(username);
        optional.ifPresent(user -> checkPassword(username, password));
    }

    public void logoutUser(String userId) {
        Optional<UserEntity> optional = repository.findById(userId);
        optional.ifPresent(user -> logout(userId));
    }

    public User addUser(User newUserRequest) {
        UserEntity newUser = convertToUserEntity(newUserRequest);
        UserEntity saved = repository.save(newUser);
        return convertToUser(saved);
    }

    public User updateUser(User updateUserRequest) {
        Optional<UserEntity> optional = repository.findById(updateUserRequest.getId());
        if (optional.isEmpty()) {
            return null;
        }

        UserEntity userEntity = optional.get();
        updateUserByRequest(userEntity, updateUserRequest);
        UserEntity saved = repository.save(userEntity);
        return convertToUser(saved);
    }

    public User getById(String userId) {
        Optional<UserEntity> optional = repository.findById(userId);
        return optional
                .map(this::convertToUser)
                .orElse(null);
    }

    public void delete(String userId) {
        repository.deleteById(userId);
    }

    private void checkPassword(String username, String password) {
        // will be implemented later
    }

    private void logout(String username) {
        // will be implemented later
    }

    private UserEntity convertToUserEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .build();
    }

    private User convertToUser(UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .build();
    }

    private void updateUserByRequest(UserEntity user, User updateUserRequest) {
        user.setLastName(updateUserRequest.getLastName());
        // update of other fields
    }
}
