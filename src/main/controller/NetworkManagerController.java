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
			if (request.getString("PasswordModificaUtente") != null) {
				Modificaprofilo(request);
			} else {
				System.out.println(choice);
				MainDispatcher.getInstance().callView("NetworkManager", request);
			}
			//Modificaprofilo(request);
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
//		Request request= new Request();
//		request.put("option", "3");
		// MainDispatcher.getInstance().callView("NetworkManager", request);

		System.out.println("ci sono");
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
