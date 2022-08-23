package ru.example.backend.ticket.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Flight {
    private int id;
    private long flightNumber;
    private String fromPoint;
    private String toPoint;
    private String toPointDate;
    private String fromPointDate;
    private String airCompany;
    private String flightStatus;
    private String comment;
    private List<String> passengersPhones;
}
