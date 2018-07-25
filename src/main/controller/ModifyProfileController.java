package main.controller;

import main.MainDispatcher;
import main.model.Utente;
import main.service.UtenteService;

public class ModifyProfileController implements Controller {
	private UtenteService utenteService;
	private Request request;

	@Override
	public void doControl(Request request) {
		this.utenteService = new UtenteService();
		this.request = request;

		Utente nuoviDati = (Utente) this.request.get("UtenteModificato");
		String VecchiaUsername = ((Utente) this.request.get("UserLoggato")).getUsername();

		if (utenteService.setUtente(nuoviDati, VecchiaUsername)) {
			System.out.println("\nProfilo modificato Correttamente!");
			callView();
		} else {
			System.out.println("\nErrore nella modifica del profilo!");
		}
		utenteService.setUtente(nuoviDati, VecchiaUsername);
	}

	private void callView() {
		Utente UserLoggato = (Utente) this.request.get("UserLoggato");
		Request newRequest = new Request();
		newRequest.put("UserLoggato", UserLoggato);

		switch (UserLoggato.getRuolo()) {
		case "amministratore":
			MainDispatcher.getInstance().callView("admin.Admin", newRequest);
			break;
		case "responsabile di rete":
			MainDispatcher.getInstance().callView("networkManager.NetworkManager", newRequest);
			break;
		case "utente semplice":
			MainDispatcher.getInstance().callView("user.User", newRequest);
			break;
		}
	}

}
