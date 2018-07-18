package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class UsersController implements Controller {

	private LoginService loginService;

	public UsersController() {
		loginService = new LoginService();
	}

	public void doControl(Request request) {
		String ruolo = null;
		if (request.equals(null)) {
			System.out.println("Login errato!");
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else if (request.get("ruolo") != null) {
			ruolo = request.get("ruolo").toString();
			getView(request, ruolo);
		} else if (request != null) {
			String nomeUtente = request.get("nomeUtente").toString();
			String password = request.get("password").toString();
			ruolo = loginService.login(nomeUtente, password);
			getView(request, ruolo);
		}
		// if (request != null) {
		// String ruolo;
		// if (request.get("ruolo") != null) {
		// ruolo = request.get("ruolo").toString();
		// } else {
		// String nomeUtente = request.get("nomeUtente").toString();
		// String password = request.get("password").toString();
		// ruolo = loginService.login(nomeUtente, password);
		// if (ruolo != null) {
//		switch (ruolo) {
//		case "amministratore":
//			MainDispatcher.getInstance().callView("Admin", request);
//			break;
//		case "responsabile di rete":
//			MainDispatcher.getInstance().callView("NetworkManager", request);
//			break;
//		case "utente semplice":
//			MainDispatcher.getInstance().callView("User", request);
//			break;
//		default:
//			// MainDispatcher.getInstance().callView("Admin", null);
//			// break;
//		}
		// // MainDispatcher.getInstance().callView("Admin", request);
		//
		// } else {
		// System.out.println("Login errato!");
		// MainDispatcher.getInstance().callAction("Login", "doControl", request);
		// }
		// }
		// }
	}
	
	private void getView(Request request,String ruolo) {
		switch (ruolo) {
		case "amministratore":
			MainDispatcher.getInstance().callView("Admin", request);
			break;
		case "responsabile di rete":
			MainDispatcher.getInstance().callView("NetworkManager", request);
			break;
		case "utente semplice":
			MainDispatcher.getInstance().callView("User", request);
			break;
		default:
			// MainDispatcher.getInstance().callView("Admin", null);
			// break;
		}
	}
}
