package com.virtualpairprogrammers.services;

import com.virtualpairprogrammers.dao.UtenteDAO;
import com.virtualpairprogrammers.model.Utente;

import java.util.List;

public class UtenteService {

    private UtenteDAO utenteDAO;

    public UtenteService() {
        this.utenteDAO = new UtenteDAO();
    }
    
    public boolean insertUtente (Utente utente) {
        return this.utenteDAO.insertUtente(utente);
    }
    
    public boolean setUtente (Utente utente,String VecchioUsername) {
        return this.utenteDAO.setUtente(utente, VecchioUsername);
    }
    
    public boolean deleteUtente (String nomeUtente) {
        return this.utenteDAO.deleteUtente(nomeUtente);
    }
    
    public List<Utente> getAllUtenti () {
        return this.utenteDAO.getAllUtente();
    }
    
    public int getidUtente (String Username) {
        return this.utenteDAO.idutenteUtente(Username);
    }
    
    public String getUsernameUtente(int idUtente) {
    	return this.utenteDAO.usernameUtente(idUtente);
    }
    
    public String getRuoloUtente (String Username) {
        return this.utenteDAO.getRuoloUtente(Username);
    }
//    
//    
//    public List<Utente> getAllPaziente () {
//        return this.utenteDAO.getAllPaziente();
//    }
}