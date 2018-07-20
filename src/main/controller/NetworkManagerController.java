package main.controller;

import java.util.List;
import main.MainDispatcher;
import main.model.Utente;
import main.service.UtenteService;

public class NetworkManagerController implements Controller {
	private UtenteService utenteService;

	@Override
	public void doControl(Request request) {
		this.utenteService = new UtenteService();
		int choice = (int) request.get("choice");

		switch (choice) {
		case 1:
			Visualizzanodi();
			break;
		case 2:
			Visualizzaprofilo();
			break;
		case 3:
			Modificaprofilo(request);
			MainDispatcher.getInstance().callView("NetworkManager", null);
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

	}

	private void Visualizzanodi() {

	}

	private void Visualizzaprofilo() {

	}

	private void Modificaprofilo(Request request) {

		Utente nuoviDati= (Utente)request.get("UtenteModificato");
		String VecchiaUsername=request.get("UsernameAccesso").toString();
		
		if(utenteService.setUtente(nuoviDati,VecchiaUsername)) {
			System.out.println("\nProfilo modificato Correttamente!");
		}else {
			System.out.println("\nErrore nella modifica del profilo!");
		}
		utenteService.setUtente(nuoviDati,VecchiaUsername);

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
