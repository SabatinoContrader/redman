package com.contrader.redman.service;

import com.contrader.redman.dao.UserRepository;
import com.contrader.redman.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Integer getIdByUsername(String username){
        return userRepository.findByUsername(username).getIdutente();
    }

    public int getNumPersonForRuolo(String ruolo) {
        return userRepository.countByRuolo(ruolo);
    }

    public void deleteUser(int idUser){
        userRepository.deleteByIdutente(idUser);
    }

    public List<String> FindDistinctRuoli(){
        return userRepository.FindDistinctRuoli();
    }

    public String findByIdutente(int idutente){
        return userRepository.findByIdutente(idutente).getUsername();
    }
}
