package com.contrader.redman.model;

import javax.persistence.Entity;


public class Ruolo {
    String ruolo;

    public Ruolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
}
