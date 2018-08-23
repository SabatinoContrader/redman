package com.contrader.redman.dao;

import com.contrader.redman.model.Nodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface NodoDao extends CrudRepository<Nodo, Long> {
    Nodo findByIdnodo(int idnodo);
}
