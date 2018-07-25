package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;

public class ModifyProfileView implements View {
	Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;
	}

	@Override
	public void showOptions() {
		System.out.println("Inserisci nuovo username: ");
		String nuovoUsername = getInput();
		System.out.println("Inserisci nuova password: ");
		String nuovaPassword = getInput();
		//String ruolo = ((Utente)request.get("UserLoggato")).getRuolo();
		Utente utenteModificato = new Utente(nuovoUsername, nuovaPassword);
		this.request.put("UtenteModificato", utenteModificato);
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (input.equals("")) {
			input = scanner.nextLine();
		}
		return input;
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("ModifyProfile", "doControl", this.request);
	}

}
