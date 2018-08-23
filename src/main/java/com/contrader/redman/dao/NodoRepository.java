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
    //List<Nodo> findDistinctByIdresponsabile(List<Nodo>nodoList);
    //List<Nodo> getDistinctByIdresponsabile();
    @Modifying
    @Query("select distinct n.idresponsabile from nodi n where n.idresponsabile is not null")
    List<Integer> findDistinctResp();

    @Modifying
    @Query("select n.idnodo from nodi n where n.idresponsabile is NULL")
    List<Integer> getNotAssocNodes();
}
