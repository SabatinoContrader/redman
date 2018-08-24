package com.contrader.redman.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.contrader.redman.model.Nodo;

@Repository
@Transactional
public interface NodoRepository extends CrudRepository<Nodo, Long> {
//	Nodo findByIdnodo(int idnodo);
//    int countByidnodo(int idnodo);
//    List<Nodo> findAll();

    @Modifying
    @Query("select distinct n.idresponsabile from nodi n where n.idresponsabile is not null")
    List<Integer> findDistinctResp();

    @Modifying
    @Query("select n.idnodo from nodi n where n.idresponsabile is NULL")
    List<Integer> getNumAssocNodes();
}
