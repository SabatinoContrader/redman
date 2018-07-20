package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;

import java.util.List;
import java.util.Scanner;

public class NetworkManagerView implements View {

	private int choice;
	private Request request = new Request();

	@Override
	public void showResults(Request request) {
		this.request = request;
	}

	@Override
	public void showOptions() {
		System.out.println("\n--------MENU--------");
		System.out.println("****RESPONSABILE****");
		System.out.println("");
		System.out.println("1) Visualizza il tuo blocco di nodi");
		System.out.println("2) Visualuzza il tuo profilo");
		System.out.println("3) Modifica il tuo profilo");
		System.out.println("4) Visualizza lo stato dei tuoi nodi");
		System.out.println("5) visualizza le informazioni dei tuoi nodi");
		System.out.println("6) Visualizza le task associate ai tuoi nodi");
		System.out.println("7) Visualizza lo stato dei tuoi task");
		System.out.println("8) Visualizza utenti associati ai tuoi nodi");
		System.out.println("9) logout");

		this.choice = Integer.parseInt(getInput());

		if (choice == 3) {
			// System.out.println("Inserisci vecchio username: ");
			// String vecchioUsername = getInput();
			System.out.println("Inserisci nuovo username: ");
			String nuovoUsername = getInput();
			System.out.println("Inserisci nuova password: ");
			String nuovaPassword = getInput();

			// this.request.put("UsernameModificaUtente", vecchioUsername);
			Utente utenteModificato = new Utente(nuovoUsername, nuovaPassword);
			this.request.put("UtenteModificato", utenteModificato);
		}
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void submit() {

		if (choice < 1 || choice > 9) {
			MainDispatcher.getInstance().callView("NetworkManager", null);
		} else if (choice == 9) {
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else if (choice == 3) {
			this.request.put("choice", choice);
			MainDispatcher.getInstance().callAction("NetworkManager", "doControl", this.request);
		}
	}
}
