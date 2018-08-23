package com.contrader.redman.service;

import com.contrader.redman.dao.NodoRepository;
import com.contrader.redman.model.Nodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodoService {
    private NodoRepository nodoRepository;

    @Autowired
    public NodoService(NodoRepository nodoRepository) {
        this.nodoRepository = nodoRepository;
    }

    public List<Integer> findAllResponsabili() {
        return nodoRepository.findDistinctResp();
    }

    public List<Integer> getNotAssocNodes() {
        return nodoRepository.getNotAssocNodes();
    }

    public List<Nodo> findAll() {
        return (List<Nodo>) nodoRepository.findAll();
    }
}

