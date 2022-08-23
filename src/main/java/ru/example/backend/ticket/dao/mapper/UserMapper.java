package ru.example.backend.ticket.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.example.backend.ticket.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .phone(rs.getString("phone"))
                .email(rs.getString("email"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .patronymic(rs.getString("patronymic"))
                .orgInn(rs.getString("org_inn"))
                .build();
    }
}
