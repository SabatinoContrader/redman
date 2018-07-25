package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Task;
import main.model.Utente;
import main.service.TaskService;
import main.service.UtenteService;

public class UtentiController implements Controller {
	private UtenteService utenteService;
	private TaskService taskService;
	private Request request;
	private String modeUtenti;

	@Override
	public void doControl(Request request) {
		this.utenteService = new UtenteService();
		this.taskService = new TaskService();
		this.request = request;

		if (this.request.get("modeUtenti") != null) {
			
			
			modeUtenti = request.get("modeUtenti").toString();
			switch (modeUtenti) {
			case "aggiungiProfiloAdmin":
				aggiungiProfilo();
				callUtentiView();
				break;
			case "cancellaProfiloAdmin":
				canecellaProfilo();
				callUtentiView();
				break;
			case "visualizzaListaUtentiAdmin":
				List<Utente> UtentiList = utenteService.getAllUtenti();
				request.put("listaUtenti", UtentiList);
				callUtentiView();
				break;
			case "callUsersManagementAdminView":
				MainDispatcher.getInstance().callView("admin.UsersManagementAdmin", this.request);
				break;
			case "visualizzaUtentiNodiNetworkManager":
				break;
			case "callUsersManagementNetworkManagerView":
				MainDispatcher.getInstance().callView("networkManager.UsersManagementNetworkManager", this.request);
				break;
			case "back":
				back();
				break;
			}
		}
	}

	private void aggiungiProfilo() {
		Utente utente = (Utente) request.get("nuovoUtente");
		if (this.utenteService.insertUtente(utente)) {
			System.out.println("Nuovo utente Aggiunto correttamente");
		} else {
			System.out.println("Utente già esistente");
		}
	}

	private void canecellaProfilo() {
		String nomeUtente = (String) request.get("cancellaUtente");
		if (this.utenteService.deleteUtente(nomeUtente)) {
			System.out.println("Utente \"" + nomeUtente + "\" Cancellato correttamente");
		} else {
			System.out.println("Utente \"" + nomeUtente + "\" non presente");
		}
	}

	private void callUtentiView() {
		MainDispatcher.getInstance().callView("Utenti", this.request);
	}

	private void modificaProfiloPersonale() {
		Utente nuoviDati = (Utente) request.get("UtenteModificato");
		String VecchiaUsername = request.get("UsernameAccesso").toString();

		if (utenteService.setUtente(nuoviDati, VecchiaUsername)) {
			System.out.println("\nProfilo modificato Correttamente!");
		} else {
			System.out.println("\nErrore nella modifica del profilo!");
		}
	}

	private void back() {
		Utente utente = (Utente) request.get("UserLoggato");
		if (utente.getRuolo().equals("amministratore")) {
			MainDispatcher.getInstance().callView("admin.Admin", this.request);
		} else if (utente.getRuolo().equals("responsabile di rete")) {
			MainDispatcher.getInstance().callView("networkManager.NetworkManager", this.request);
		}
	}

}
