package com.contrader.redman.dao;

import com.contrader.redman.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(nativeQuery = true, value = "select distinct u.ruolo from utenti u")
    List<String> FindDistinctRuoli();

    User findByUsernameAndPassword(String username, String password);
    User findByUsername(String username);

    int countByRuolo(String ruolo);

    //List<User> findAllByRuolo(String ruolo);

    void deleteByIdutente(int idutente);

    User findByIdutente(int idutente);

}
