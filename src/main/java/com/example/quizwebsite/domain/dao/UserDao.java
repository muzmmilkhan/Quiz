package com.example.quizwebsite.domain.dao;

import com.example.quizwebsite.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("userDao")
public class UserDao extends AbstractDao<User> {
    public UserDao() {
        setClazz(User.class);
    }

    public User getUserById(int id) {
        return findById(id);
    }

    public User findByUsername(String username) {
        return (User) getCurrentSession().createQuery("from User where username = :username")
                .setParameter("username", username)
                .uniqueResult();
    }

    public void addUser(User user) {
        add(user);
    }

    public void updateActive(int userId) {
        // if IsActive is 1, set it to 0, else set it to 1
        getCurrentSession().createSQLQuery("update User set IsActive = (IsActive + 1) % 2 where id = " + userId).executeUpdate();
    }

    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("from User").list();
    }

    public Optional<User> validateLogin(String username, String password) {
        Optional<User> user = Optional.ofNullable((User) getCurrentSession().createQuery("from User where username = :username and password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult());
        System.out.println(user);
        return user;
    }
}
