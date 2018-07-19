package main.controller;

import java.util.List;
import main.MainDispatcher;
import main.model.Nodo;
import main.model.Utente;
import main.service.NodoService;
import main.service.UtenteService;

public class AdminController implements Controller {
	private UtenteService utenteService;
	private NodoService nodoService;
	
	@Override
	public void doControl(Request request) {
		this.utenteService = new UtenteService();
		this.nodoService = new NodoService();
		String mode = request.get("mode").toString();
		
		switch (mode) {
		case "insert":
			Utente utente =(Utente) request.get("NuovoUtente");
			if(utenteService.insertUtente(utente)){
				System.out.println("Nuovo utente Aggiunto correttamente\n");
			}else {
				System.out.println("Utente già esistente");
			}
			MainDispatcher.getInstance().callView("Admin", null);
			break;
		case "VisualizzaListaNodi":
			List<Nodo> nodi = nodoService.getAllnodi();
			request.put("listaNodi", nodi);
			MainDispatcher.getInstance().callView("Admin", request);
			//request.put("mode", "all");
			break;	
		case "VisualizzaListaUtenti":
			List<Utente> UtentiList = utenteService.getAllUtenti();
			request.put("listaUtenti", UtentiList);
			MainDispatcher.getInstance().callView("Admin", request);
			//request.put("mode", "all");
			break;
//		case 9:
//			Utente newUtente = new Utente();
//			newUtente = (Utente) request.get("newUtente");
//			UtenteService.insertUtente(newUtente);
//			MainDispatcher.getInstance().callView("Home", null);
//			break;
		}
		//MainDispatcher.getInstance().callView("Admin", request);

	
	}

}
