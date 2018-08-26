package com.contrader.redman.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "utenti")
@Table(name = "utenti")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idutente;

    @NotNull
    private String ruolo;

    @NotNull
    private String username;

    @NotNull
    private String password;

    public User(String ruolo, String username, String password) {
        this.ruolo = ruolo;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_UTENTE")*/
    public int getIdutente() {
        return idutente;
    }

    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getPassword() {
        return password;
    }

/*    @OneToMany
    @JoinTable(name = "Nodi_list",joinColumns = @JoinColumn(name = "ID_UTENTE"),inverseJoinColumns =@JoinColumn(name = "ID_RESPONSABILE"))
    private List<Nodo> nodi;*/
}


