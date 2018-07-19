package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class UsersController implements Controller {

	private LoginService loginService;

	public UsersController() {
		loginService = new LoginService();
	}

	public void doControl(Request request) {
		if (request != null) {
			String nomeUtente = request.get("nomeUtente").toString();
			String password = request.get("password").toString();
			String ruolo = loginService.login(nomeUtente, password);
			if (ruolo != null) {
				if (ruolo.equalsIgnoreCase("amministratore")) {
					MainDispatcher.getInstance().callView("Admin", request);
				} else if (ruolo.equalsIgnoreCase("responsabile di rete")) {
					MainDispatcher.getInstance().callView("NetworkManager", request);
				} else if (ruolo.equalsIgnoreCase("utente semplice")) {
					MainDispatcher.getInstance().callView("User", request);
				}
			} else {
				System.out.println("Login Errato");
				MainDispatcher.getInstance().callAction("Login", "doControl", request);
			}
		} else {
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
