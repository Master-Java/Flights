package ru.example.backend.ticket.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.backend.ticket.domain.Flight;
import ru.example.backend.ticket.domain.User;
import ru.example.backend.ticket.sevice.FlightService;
import ru.example.backend.ticket.sevice.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/rest/v1/")
public class MainRestController {

    private final FlightService flightService;
    private final UserService userService;

    @GetMapping("/flights")
    @ApiOperation("Получение всех полётов")
    public List<Flight> getAllTickets() {
        return flightService.getAll();
    }

    @PostMapping("/flight")
    @ApiOperation("Создание нового полёта")
    public void createFlight(@RequestBody Flight flight) {
        flightService.createFlight(flight);
    }

    @PutMapping("/flight/{id}")
    @ApiOperation("Изменение полёта")
    public void updateFlight(@RequestBody Flight flight, @PathVariable int id) {
        flightService.updateFlight(flight, id);
    }

    @GetMapping("/flights/{phone}")
    @ApiOperation("Получение полётов для указанного номера телефона (пользователя)")
    public List<Flight> updateUser(@PathVariable String phone) {
        return flightService.getFlightsByUserPhone(phone);
    }

    @DeleteMapping("/flights/delete/{idFlight}")
    @ApiOperation("Удаление полёта по его id")
    public void deleteFlights(@PathVariable int idFlight) {
        flightService.deleteFlight(idFlight);
    }

    @PostMapping("/user")
    @ApiOperation("Создание нового пользователя")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/user/{phone}")
    @ApiOperation("Изменение пользователя")
    public void updateUser(@RequestBody User user, String phone) {
        userService.updateUser(user, phone);
    }

    @GetMapping("/user/by_phone/{phone}")
    @ApiOperation("Получение пользователя по номеру его телефона")
    public User getUserByPhone(@PathVariable String phone) {
        return userService.getUserByPhone(phone);
    }
}
