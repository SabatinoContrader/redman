package com.contrader.redman.dao;

import com.contrader.redman.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    User findByUsernameAndPassword(String username,String password);
}
