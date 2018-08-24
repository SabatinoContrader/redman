package com.contrader.redman.service;

import com.contrader.redman.dao.UserDao;
import com.contrader.redman.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }

    public Iterable<User> findAll() {
        return userDao.findAll();
    }

    public void save(User user) {
        userDao.save(user);
    }

    public int getNumPersonForRuolo(String ruolo) {
        return userDao.countByRuolo(ruolo);
    }

    public void deleteUser(int idUser){
        userDao.deleteByIdutente(idUser);
    }
}
