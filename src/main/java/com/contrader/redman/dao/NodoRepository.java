package com.contrader.redman.dao;

import com.contrader.redman.model.Nodo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface NodoRepository extends CrudRepository<Nodo, Long> {

    @Modifying
    @Query("select distinct n.idresponsabile from nodi n where n.idresponsabile is not null")
    List<Integer> findDistinctResp();

    List<Nodo> findByIdresponsabileIsNull();

    void deleteByIdnodo(int idNodo);

    /*@Modifying
    @Query("select n from nodi n inner join utenti u on u.idutente=n.idresponsabile")
    List<Nodo> findAll();*/

    //String findUsernameById
}
