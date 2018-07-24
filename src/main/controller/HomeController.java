package main.controller;

import main.MainDispatcher;
import main.model.Utente;
import main.service.LoginService;
import main.service.UtenteService;

public class HomeController implements Controller {

	private LoginService loginService;
	private UtenteService utenteService;
	private Request request;

	public HomeController() {
		loginService = new LoginService();
		utenteService= new UtenteService();

	}

	public void doControl(Request request) {
		this.request=request;
		if (this.request.get("mode") == "modificaUtente") {
			modificaProfilo();
			Request newRequest=new Request();
			newRequest.put("UserLoggato", this.request.get("UtenteModificato"));
			MainDispatcher.getInstance().callView("Home", newRequest);
		}else if (request.get("UserLoggato") != null) {
			MainDispatcher.getInstance().callView("Home", request);
		}else {
			String nomeUtente = request.get("nomeUtente").toString();
			String password = request.get("password").toString();
			String ruolo = loginService.login(nomeUtente, password);
			Utente utente = new Utente(ruolo, nomeUtente, password);
			request.put("UserLoggato", utente);

			if (ruolo != null) {
				/*
				 * request.put("UsernameAccesso", nomeUtente); if
				 * (ruolo.equalsIgnoreCase("amministratore")) {
				 * MainDispatcher.getInstance().callView("Admin", request); } else if
				 * (ruolo.equalsIgnoreCase("responsabile di rete")) {
				 * MainDispatcher.getInstance().callView("NetworkManager", request); } else if
				 * (ruolo.equalsIgnoreCase("utente semplice")) {
				 * MainDispatcher.getInstance().callView("User", request); }
				 */
				MainDispatcher.getInstance().callView("Home", request);
			} else {
				System.out.println("Login Errato");
				MainDispatcher.getInstance().callAction("Login", "doControl", request);
			}
		}
//		} else {
//			MainDispatcher.getInstance().callView("Login", null);
//		}
	}
	
	private void modificaProfilo() {
		Utente nuoviDati = (Utente) this.request.get("UtenteModificato");
		String VecchiaUsername = ((Utente) request.get("UserLoggato")).getUsername();

		if (utenteService.setUtente(nuoviDati, VecchiaUsername)) {
			System.out.println("\nProfilo modificato Correttamente!");
		} else {
			System.out.println("\nErrore nella modifica del profilo!");
		}
		utenteService.setUtente(nuoviDati, VecchiaUsername);
	}
}
