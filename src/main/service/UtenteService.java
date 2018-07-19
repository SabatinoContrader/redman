package main.service;

import main.dao.UtenteDAO;
import main.model.Utente;

import java.util.List;

public class UtenteService {

    private UtenteDAO utenteDAO;

    public UtenteService() {
        this.utenteDAO = new UtenteDAO();
    }
    
    public boolean insertUtente (Utente utenti) {
        return this.utenteDAO.insertUtente(utenti);
    }
    
    public boolean setUtente (Utente utenti) {
        return this.utenteDAO.setUtente(utenti);
    }
    
    public boolean deleteUtente (Utente utenti) {
        return this.utenteDAO.deleteUtente(utenti);
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