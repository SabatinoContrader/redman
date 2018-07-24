package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Utente;
import main.service.UtenteService;

public class UtentiController implements Controller {
	private UtenteService utenteService;
	private Request request;
	private String mode;

	@Override
	public void doControl(Request request) {
		this.utenteService = new UtenteService();
		this.request = request;

		if (this.request.get("mode") != null) {
			mode = request.get("mode").toString();
			switch (mode) {
			case "aggiungiUtente":
				aggiungiProfilo();
				callUtentiView();
				break;
			case "cancellaUtente":
				canecellaProfilo();
				callUtentiView();
				break;
			case "visualizzaListaUtenti":
				List<Utente> UtentiList = utenteService.getAllUtenti();
				request.put("listaUtenti", UtentiList);
				callUtentiView();
				break;
			case "visualizzaUtentiNodi":
				break;
			case "back":
				Request newRequest=new Request();
				newRequest.put("UserLoggato", this.request.get("UserLoggato"));
				MainDispatcher.getInstance().callAction("Home", "doControl", newRequest);
				break;

			}
		} else {
			// MainDispatcher.getInstance().callView("Utenti", this.request);
			callUtentiView();
		}
	}

	private void aggiungiProfilo() {
		Utente utente = (Utente) request.get("nuovoUtente");
		if (this.utenteService.insertUtente(utente)) {
			System.out.println("Nuovo utente Aggiunto correttamente\n");
		} else {
			System.out.println("Utente già esistente");
		}
		// MainDispatcher.getInstance().callView("Admin", null);
	}

	private void canecellaProfilo() {
		String nomeUtente = (String) request.get("cancellaUtente");
		if (this.utenteService.deleteUtente(nomeUtente)) {
			System.out.println("Utente \"" + nomeUtente + "\" Cancellato correttamente\n");
		} else {
			System.out.println("Utente \"" + nomeUtente + "\" non presente");
		}
		// MainDispatcher.getInstance().callView("Admin", null);
	}

	private void callUtentiView() {
		MainDispatcher.getInstance().callView("Utenti", this.request);
	}

}
