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
			String ruolo=loginService.login(nomeUtente, password);
			if (ruolo != null) {
				switch(ruolo) {
				case "amministratore": MainDispatcher.getInstance().callView("Admin", request);
				break;
				case"responsabile di rete":MainDispatcher.getInstance().callView("NetworkManager", request);
					break;
				case"utente semplice":MainDispatcher.getInstance().callView("User", request);
				
				default:
//					MainDispatcher.getInstance().callView("Admin", null);
//					break;
				}
				//MainDispatcher.getInstance().callView("Admin", request);

			}else
				MainDispatcher.getInstance().callAction("Login", "doControl", request);
		} else
			MainDispatcher.getInstance().callView("Home", null);
	}
}
