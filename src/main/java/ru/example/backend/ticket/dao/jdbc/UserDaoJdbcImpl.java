package ru.example.backend.ticket.dao.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.example.backend.ticket.dao.UserDao;
import ru.example.backend.ticket.dao.mapper.UserMapper;
import ru.example.backend.ticket.domain.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDaoJdbcImpl implements UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public User getUserByPhone(String phone) {
        String sql = "" +
                "SELECT *" +
                " FROM users" +
                " WHERE phone = :phone;";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("phone", phone), new UserMapper());
    }

    @Override
    public List<String> getUsersPhoneById(int id) {
        String sql = "" +
                "SELECT u.phone" +
                " FROM users u JOIN users_flights uf ON u.phone = uf.user_phone" +
                " WHERE uf.id = :id;";
        return jdbcTemplate.queryForList(sql, new MapSqlParameterSource("id", id), String.class);
    }

    @Override
    public Boolean checkExistUserByPhone(String phone) {
        String sql = "" +
                "SELECT (COUNT(*) > 0)" +
                " FROM users" +
                " WHERE phone = :phone;";
        return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("phone", phone), Boolean.class);
    }

    @Override
    public void createUser(User user) {
        String sql = "" +
                "INSERT INTO users (phone, surname, name, patronymic, email, org_inn)" +
                " VALUES (:phone, :surname, :name, :patronymic, :email, :orgInn);";
        jdbcTemplate.update(sql, getMapSqlParameterSource(user));
    }

    @Override
    public void updateUser(User user, String phone) {
        String sql = "" +
                "UPDATE users" +
                " SET" +
                "    surname = :surname," +
                "    name = :name," +
                "    patronymic = :patronymic," +
                "    email = :email," +
                "    org_inn = :orgInn" +
                " WHERE phone = :phone;";
        MapSqlParameterSource param = getMapSqlParameterSource(user);
        param.addValue("phone", phone);
        jdbcTemplate.update(sql, param);
    }

    private MapSqlParameterSource getMapSqlParameterSource(User user) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("surname", user.getSurname());
        param.addValue("name", user.getName());
        param.addValue("patronymic", user.getPatronymic());
        param.addValue("email", user.getEmail());
        param.addValue("orgInn", user.getOrgInn());
        param.addValue("phone", user.getPhone());
        return param;
    }
}
