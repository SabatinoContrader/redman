package main.service;

	import main.dao.NodoDAO;
	import main.model.Nodo;

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
	    public List<Nodo> getResponsabileNodi(int idutente) {
	        return this.nodoDAO.getResponsabileNodi(idutente);
	    }
	    
	    
	    public boolean UtenteNodo (int idUtente, int idNodo) {
	        return this.nodoDAO.UtenteNodo(idUtente, idNodo);
	    }
	    
	    
	    
	    
	//    
	//    
//	    public List<Utente> getAllPaziente () {
//	        return this.utenteDAO.getAllPaziente();
//	    }
	}
