package main.controller;

import java.util.List;
import main.MainDispatcher;
import main.model.Utente;
import main.service.GommaService;
import main.service.UtenteService;

public class AdminController implements Controller {
	private UtenteService utenteService;
	
	@Override
	public void doControl(Request request) {
		this.utenteService = new UtenteService();
		int choice = (int) request.get("choice");
		switch (choice) {
		case 1:
			request.put("mode", "insert");
			break;
		case 8:
			List<Utente> UtentiList = utenteService.getAllUtenti();
			request.put("listaUtenti", UtentiList);
			request.put("mode", "all");
			break;
		case 9:
//			Utente newUtente = new Utente();
//			newUtente = (Utente) request.get("newUtente");
//			UtenteService.insertUtente(newUtente);
//			MainDispatcher.getInstance().callView("Home", null);
			break;
		}
		MainDispatcher.getInstance().callView("Admin", request);

	
	}

}
