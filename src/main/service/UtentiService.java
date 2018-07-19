package main.service;

import main.dao.UtentiDAO;
import main.model.Utenti;

import java.util.List;

public class UtentiService {

    private UtentiDAO utentiDAO;

    public UtentiService() {
        this.utentiDAO = new UtentiDAO();
    }
    
    public boolean insertUtenti (Utenti utenti) {
        return this.utentiDAO.insertUtente(utenti);
    }
    
    public boolean setUtenti (Utenti utenti) {
        return this.utentiDAO.setUtente(utenti);
    }
    
    public boolean deleteUtente (Utenti utenti) {
        return this.utentiDAO.deleteUtente(utenti);
    }
    
//    public List<Utente> getAllDottore () {
//        return this.utenteDAO.getAllDottore();
//    }
//    
//    
//    public List<Utente> getAllPaziente () {
//        return this.utenteDAO.getAllPaziente();
//    }
}