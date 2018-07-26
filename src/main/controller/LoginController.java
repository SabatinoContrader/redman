package main.controller;

import main.MainDispatcher;
import main.model.Utente;
import main.service.LoginService;

public class LoginController implements Controller {
	private Request request;
	private LoginService loginService;

	public LoginController() {
		loginService = new LoginService();
	}

	public void doControl(Request request) {
		Utente UserLoggato;
		this.request = request;
		
		if(this.request==null) {
			MainDispatcher.getInstance().callView("Login", request);
		}else if(checkUser()) {
			UserLoggato=(Utente)this.request.get("UserLoggato");
			Request newRequest= new Request();
			newRequest.put("UserLoggato", UserLoggato);
			
/*GNANNA DA UBUNtu*/
			
			switch(UserLoggato.getRuolo()) {
			case"amministratore":
				MainDispatcher.getInstance().callView("admin.Admin", newRequest);
				break;
			case"responsabile di rete":
				MainDispatcher.getInstance().callView("networkManager.NetworkManager", newRequest);
				break;
			case"utente semplice":
				MainDispatcher.getInstance().callView("user.User", newRequest);
				break;
			}
		}else {
			MainDispatcher.getInstance().callView("Login", request);
		}
	}

	private boolean checkUser() {
		String nomeUtente = this.request.get("nomeUtente").toString();
		String password = this.request.get("password").toString();
		String ruolo = loginService.login(nomeUtente, password);
		if (ruolo != null) {
			Utente utente = new Utente(ruolo, nomeUtente, password);
			this.request.put("UserLoggato", utente);
			//MainDispatcher.getInstance().callView("Home", request);
			return true;
		} else {
			System.out.println("Login Errato");
			//MainDispatcher.getInstance().callView("Login", null);
			return false;
		}
	}
}
