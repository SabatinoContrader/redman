package com.contrader.redman.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Entity (name = "nodi")
@Table(name = "nodi")
public class Nodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idnodo;

    Integer idresponsabile;

    Integer idutentesemplice;

    @NotNull
    String infonodo;

    @NotNull
    String statonodo;

    @NotNull
    int gruppi_idgruppo;

    public Nodo(@NotNull String infonodo, @NotNull String statonodo, @NotNull int gruppi_idgruppo) {
        this.infonodo = infonodo;
        this.statonodo = statonodo;
        this.gruppi_idgruppo = gruppi_idgruppo;
    }

    public Nodo(int idresponsabile, @NotNull String infonodo, @NotNull String statonodo, @NotNull int gruppi_idgruppo) {
        this.idresponsabile = idresponsabile;
        this.infonodo = infonodo;
        this.statonodo = statonodo;
        this.gruppi_idgruppo = gruppi_idgruppo;
    }

    public Nodo(int idresponsabile, int idutentesemplice, @NotNull String infonodo, @NotNull String statonodo, @NotNull int gruppi_idgruppo) {
        this.idresponsabile = idresponsabile;
        this.idutentesemplice = idutentesemplice;
        this.infonodo = infonodo;
        this.statonodo = statonodo;
        this.gruppi_idgruppo = gruppi_idgruppo;
    }

    public Nodo() {
    }

    public int getIdnodo() {
        return idnodo;
    }

    public void setIdnodo(int idnodo) {
        this.idnodo = idnodo;
    }

    public Integer getIdresponsabile() {
        return idresponsabile;
    }

    public void setIdresponsabile(Integer idresponsabile) {
        this.idresponsabile = idresponsabile;
    }

    public Integer getIdutentesemplice() {
        return idutentesemplice;
    }

    public void setIdutentesemplice(Integer idutentesemplice) {
        this.idutentesemplice = idutentesemplice;
    }

    public String getInfonodo() {
        return infonodo;
    }

    public void setInfonodo(String infonodo) {
        this.infonodo = infonodo;
    }

    public String getStatonodo() {
        return statonodo;
    }

    public void setStatonodo(String statonodo) {
        this.statonodo = statonodo;
    }

    public int getGruppi_idgruppo() {
        return gruppi_idgruppo;
    }

    public void setGruppi_idgruppo(int gruppi_idgruppo) {
        this.gruppi_idgruppo = gruppi_idgruppo;
    }
}