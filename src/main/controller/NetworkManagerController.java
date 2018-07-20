package main.controller;

import java.util.List;
import main.MainDispatcher;
import main.model.Utente;
import main.service.UtenteService;

public class NetworkManagerController implements Controller {
	private UtenteService utenteService;
	private Request request = new Request();

	@Override
	public void doControl(Request request) {
		this.utenteService = new UtenteService();
		this.request = request;

		if (this.request == null) {
			MainDispatcher.getInstance().callView("NetworkManager", null);
		} else {
			int choice = (int) this.request.get("choice");
			switch (choice) {
			case 1:
				Visualizzanodi();
				break;
			case 2:
				Visualizzaprofilo();
				break;
			case 3:
				Modificaprofilo();
				break;
			case 4:
				Visualizzastatonodi();
				break;
			case 5:
				Visualizzainfonodi();
				break;
			case 6:
				Visualizzatask();
				break;
			case 7:
				Visualizzastatotask();
				break;
			case 8:
				Visualizzautentinodi();
				break;

			}
			MainDispatcher.getInstance().callView("NetworkManager", null);
		}

	}

	private void Visualizzanodi() {

	}

	private void Visualizzaprofilo() {

	}

	private void Modificaprofilo() {

		Utente nuoviDati = (Utente) this.request.get("UtenteModificato");
		String VecchiaUsername = this.request.get("UsernameAccesso").toString();

		if (utenteService.setUtente(nuoviDati, VecchiaUsername)) {
			System.out.println("\nProfilo modificato Correttamente!");
		} else {
			System.out.println("\nErrore nella modifica del profilo!");
		}
		utenteService.setUtente(nuoviDati, VecchiaUsername);

	}

	private void Visualizzastatonodi() {

	}

	private void Visualizzainfonodi() {

	}

	private void Visualizzatask() {

	}

	private void Visualizzastatotask() {

	}

	private void Visualizzautentinodi() {

	}

}
