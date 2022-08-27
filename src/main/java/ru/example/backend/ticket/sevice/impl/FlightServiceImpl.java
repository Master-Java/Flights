package ru.example.backend.ticket.sevice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.example.backend.ticket.dao.FlightDao;
import ru.example.backend.ticket.domain.Flight;
import ru.example.backend.ticket.domain.User;
import ru.example.backend.ticket.sevice.FlightService;
import ru.example.backend.ticket.sevice.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightDao flightDao;
    private final UserService userService;

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = flightDao.getAll();
        fillPassengers(flights);
        return flights;
    }

    private void fillPassengers(List<Flight> flights) {
        for (Flight flight : flights) {
            flight.setPassengersPhones(userService.getUsersPhoneById(flight.getId()));
        }
    }

    @Override
    public Flight getByFlightNumber(long flightNumber) {
        return flightDao.getByFlightNumber(flightNumber);
    }

    @Override
    public void updateFlight(Flight flight, int id) {
        flightDao.deleteLinkPassengersPhoneWithFlight(id);
        flightDao.updateFlight(flight, id);
        createNewUsersAndNewLinkPassengersPhoneWithFlight(flight, id);
    }

    @Override
    public void createFlight(Flight flight) {
        flight.setId(flightDao.createFlight(flight));
        createNewUsersAndNewLinkPassengersPhoneWithFlight(flight, flight.getId());
    }

    private void createNewUsersAndNewLinkPassengersPhoneWithFlight(Flight flight, int id) {
        for (String phone : flight.getPassengersPhones()) {
            createNewUsers(phone, id);
        }
    }

    private void createNewUsers(String phone, int id) {
        if (!userService.checkExistUserByPhone(phone)) {
            userService.createUser(User.builder().phone(phone).build());
            flightDao.createNewLinkPassengersPhoneWithFlight(id, phone);
        }
    }

    @Override
    public List<Flight> getFlightsByUserPhone(String phone) {
        return flightDao.getFlightsByUserPhone(phone);
    }

    @Override
    public void deleteFlight(int id) {
        flightDao.deleteLinkPassengersPhoneWithFlightByFlightId(id);
        flightDao.deleteFlight(id);
    }

    @Override
    @Scheduled(fixedRate = 850 * 60)
    public void updateStatus() {
        flightDao.updateStatusArchive();
        flightDao.updateStatusInAWay();
    }
}