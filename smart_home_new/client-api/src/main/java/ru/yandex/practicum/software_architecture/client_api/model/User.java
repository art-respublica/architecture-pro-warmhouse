package ru.yandex.practicum.software_architecture.client_api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class User {

    private String id;

    private String lastName;
    private String firstName;
    private String middleName;

    private String agreementId;

    List<House> houses;
}
