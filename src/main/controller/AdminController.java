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
//		case 2:
//			List<Gomma> gomme = gommaService.getAllGomme();
//			request.put("listaGomma", gomme);
//			request.put("mode", "all");
//			break;
		case 9:
			Gomma newGomma = new Gomma();
			newGomma = (Gomma) request.get("newGomma");
			gommaService.insertGomma(newGomma);
			MainDispatcher.getInstance().callView("Home", null);
			break;
		}
		MainDispatcher.getInstance().callView("Admin", request);

	
	}

}
