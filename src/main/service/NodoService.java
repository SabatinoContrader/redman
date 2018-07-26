package main.service;

	import main.ConnectionSingleton;
import main.dao.NodoDAO;
	import main.model.Nodo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

	public class NodoService {

	    private NodoDAO nodoDAO;

	    public NodoService() {
	        this.nodoDAO = new NodoDAO();
	    }
	    
	    public boolean insertNodo (Nodo nodo) {
	        return this.nodoDAO.insertNodo(nodo);
	    }
	    
	    /*public boolean setNodo (Nodo nodo) {
	        return this.nodoDAO.setNodi(nodo);
	    }
	    
	    public boolean deleteNodo (Nodo nodo) {
	        return this.nodoDAO.deleteNodi(nodo);
	    }*/
	    
	    public List<Nodo> getAllnodi () {
	        return this.nodoDAO.getAllNodi();
	      
	       }
	    
	    public HashMap<Integer,String> getAllNodiUtenti() {
			return this.nodoDAO.getAllNodiUtenti();
			
		}
	    
	    public List<Nodo> getResponsabileNodi(int idutente) {
	        return this.nodoDAO.getResponsabileNodi(idutente);
	    }
	    
	    
	    public boolean UtenteNodo (int idUtente, int idNodo) {
	        return this.nodoDAO.UtenteNodo(idUtente, idNodo);
	    }
	    
	    public boolean UtenteNullNodo (int idNodo) {
	        return this.nodoDAO.UtenteNullNodo(idNodo);
	    }
	    
	    public List<Nodo> getStatoNodi(int idUtente) {
	    	return this.nodoDAO.getStatoNodi(idUtente);
	    }	    
	    
	    
	//    
	//    
//	    public List<Utente> getAllPaziente () {
//	        return this.utenteDAO.getAllPaziente();
//	    }
	}
