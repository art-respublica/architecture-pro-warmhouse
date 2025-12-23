package ru.yandex.practicum.software_architecture.client_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.client_api.model.User;
import ru.yandex.practicum.software_architecture.client_api.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserProfileController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User registerUser(@RequestBody User newUserRequest) {
        return userService.addUser(newUserRequest);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public User updateUser(@RequestBody User updateUserRequest) {
        return userService.updateUser(updateUserRequest);
    }

    @GetMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.OK)
    public User getById(@PathVariable String userId) {
        return userService.getById(userId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String userId) {
        userService.delete(userId);
    }
}
