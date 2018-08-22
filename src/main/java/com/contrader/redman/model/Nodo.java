package com.contrader.redman.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nodi")
public class Nodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idnodo;

    @NotNull
    private String idresponsabile;

    @NotNull
    private String idutentesemplice;

    @NotNull
    private String infonodo;
    
    @NotNull
    private String statonodo;
    
    @NotNull
    private int gruppi_idgruppo;

    public Nodo() {
    }

    public int getIdnodo() {
        return idnodo;
    }
    public void setIdnodo(int idnodo) {
        this.idnodo = idnodo;
    }

    public String getIdresponsabile() {
        return idresponsabile;
    }
    public void setIdresponsabile(String idresponsabile) {
        this.idresponsabile = idresponsabile;
    }

    public void setIdutentesemplice(String idutentesemplice) {
        this.idutentesemplice = idutentesemplice;
    }
    public String getIdutentesemplice() {
        return idutentesemplice;
    }

    public void setInfonodo(String infonodo) {
        this.infonodo = infonodo;

    }
    public String getInfonodo() {
        return infonodo;
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