package com.contrader.redman.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Entity (name = "nodi")
@Table(name = "nodi")
public class Nodo implements Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idnodo;

    String idresponsabile;

    String idutentesemplice;

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

    public Nodo(String idresponsabile, @NotNull String infonodo, @NotNull String statonodo, @NotNull int gruppi_idgruppo) {
        this.idresponsabile = idresponsabile;
        this.infonodo = infonodo;
        this.statonodo = statonodo;
        this.gruppi_idgruppo = gruppi_idgruppo;
    }

    public Nodo(String idresponsabile, String idutentesemplice, @NotNull String infonodo, @NotNull String statonodo, @NotNull int gruppi_idgruppo) {
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

/*    @Column(name = "ID_RESPONSABILE")*/
    public String getIdresponsabile() {
        return idresponsabile;
    }

    public void setIdresponsabile(String idresponsabile) {
        this.idresponsabile = idresponsabile;
    }

    public String getIdutentesemplice() {
        return idutentesemplice;
    }

    public void setIdutentesemplice(String idutentesemplice) {
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

/*    @JoinTable(name = "USER",joinColumns = @JoinColumn(name = "ID_RESPONSABILE"),inverseJoinColumns =@JoinColumn(name = "ID_UTENTE"))
    @ManyToOne(fetch = FetchType.LAZY)
    *//*  @JoinColumn(name = "idutente")*//*
    private User user;*/

    @Override
    public Nodo clone(){
        try {
            return (Nodo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}