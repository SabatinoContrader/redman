package com.contrader.redman.dao;

import com.contrader.redman.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsernameAndPassword(String username,String password);
    int countByRuolo(String ruolo);
    List<User> findAllByRuolo(String ruolo);
}
