package ru.example.backend.ticket.sevice.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.backend.ticket.dao.UserDao;
import ru.example.backend.ticket.domain.User;
import ru.example.backend.ticket.sevice.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }

    @Override
    public List<String> getUsersPhoneById(int id) {
        return userDao.getUsersPhoneById(id);
    }

    @Override
    public Boolean checkExistUserByPhone(String phone) {
        return userDao.checkExistUserByPhone(phone);
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User user, String phone) {
        userDao.updateUser(user, phone);
    }
}
