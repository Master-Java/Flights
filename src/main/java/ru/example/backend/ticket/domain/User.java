package ru.example.backend.ticket.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String phone;
    private String surname;
    private String name;
    private String patronymic;
    private String email;
    private String orgInn;
}
