package com.contrader.redman.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtask;

    private int idnodo;

    @NotNull
    private int idutente;

    @NotNull
    private String infotask;
    
    @NotNull
    private String statotask;

    public Task() {
    }

    public int getIdtask() {
        return idtask;
    }
    public void setIdtask(int idtask) {
        this.idtask = idtask;
    }

    public int getIdnodo() {
        return idnodo;
    }
    public void setIdnodo(int idnodo) {
        this.idnodo = idnodo;
    }

    public int getIdutente() {
        return idutente;
    }
    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }

    public void setInfotask(String infotask) {
        this.infotask = infotask;

    }
    public String getInfotask() {
        return infotask;
    }
    
    public void setStatotask(String statotask) {
        this.statotask = statotask;

    }
    public String getStatotask() {
        return statotask;
    }
}
