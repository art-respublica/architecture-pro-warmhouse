package ru.yandex.practicum.software_architecture.client_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.software_architecture.client_api.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

    private final UserService userService;

    @GetMapping("/user/login")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Void> loginUser(@RequestParam String username,
                                          @RequestParam String password) {
        userService.loginUser(username, password);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/logout")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Void> logoutUser(@RequestParam String username) {
        userService.logoutUser(username);
        return ResponseEntity.ok().build();
    }
}
