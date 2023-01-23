package com.example.quizwebsite.service;

import com.example.quizwebsite.domain.dao.UserDao;
import com.example.quizwebsite.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private UserDao userDao;

    @Autowired
    @Qualifier("userDao")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
    @Transactional
    public void addUser(User user) {
        try {
            userDao.addUser(user);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @Transactional
    public void updateActive(int userId) {
        userDao.updateActive(userId);
    }

    public Optional<User> validateLogin(String username, String password) {
        return userDao.validateLogin(username, password);
    }
}
