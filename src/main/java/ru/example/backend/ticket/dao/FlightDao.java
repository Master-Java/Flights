package ru.example.backend.ticket.dao;

import ru.example.backend.ticket.domain.Flight;

import java.util.List;

public interface FlightDao {
    List<Flight> getAll();

    void updateFlight(Flight flight, int id);

    void createNewLinkPassengersPhoneWithFlight(int id, String passengerPhone);

    void deleteLinkPassengersPhoneWithFlight(int id);

    int createFlight(Flight flight);

    List<Flight> getFlightsByUserPhone(String phone);

    void deleteFlight(int id);

    Flight getByFlightNumber(long flightNumber);

    void deleteLinkPassengersPhoneWithFlightByFlightId(int id);

    void updateStatusInAWay();

    void updateStatusArchive();
}
