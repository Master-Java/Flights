package ru.example.backend.ticket.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.example.backend.ticket.domain.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightMapper implements RowMapper<Flight> {
    @Override
    public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Flight.builder()
                .id(rs.getInt("id"))
                .flightNumber(rs.getLong("flight_number"))
                .fromPoint(rs.getString("from_point"))
                .toPoint(rs.getString("to_point"))
                .toPointDate(rs.getString("to_point_date"))
                .fromPointDate(rs.getString("from_point_date"))
                .airCompany(rs.getString("air_company"))
                .flightStatus(rs.getString("flight_status"))
                .comment(rs.getString("comment"))
                .build();
    }
}