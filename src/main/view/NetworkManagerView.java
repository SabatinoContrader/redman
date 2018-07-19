package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;

import java.util.List;
import java.util.Scanner;

public class NetworkManagerView implements View {

	private int choice;
	private Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;
		// int option=(int)request.get("option");
		if (request != null) {
			if (request.get("choice") != null) {
				switch ((int) request.get("choice")) {
				case 1:
					break;
				case 2:

					break;
				case 3:
					System.out.println("Inserisci vecchio username: ");
					String vecchioUsername = getInput();
					System.out.println("Inserisci nuovo username: ");
					String nuovoUsername = getInput();
					System.out.println("Inserisci nuova password: ");
					String nuovaPassword = getInput();
					System.out.println("Inserisci nuovo ruolo: ");
					String nuovoRuolo = getInput();
					this.request.put("UsernameModificaUtente", vecchioUsername);
					Utente utenteModificato = new Utente(nuovoRuolo, nuovoUsername, nuovaPassword);
					this.request.put("UtenteModificato", utenteModificato);
					// MainDispatcher.getInstance().callAction("NetworkManager", "doControl",
					// request);
					break;
				case 4:

					break;
				case 5:

					break;
				case 6:

					break;
				case 7:

					break;
				case 8:

					break;
				}
			}
		}
	}

	@Override
	public void showOptions() {
		if (request != null) {
			if (request.getString("UsernameModificaUtente") != null) {
				choice = (int) request.get("choice");
			} else {
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
			}
		}
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void submit() {
		if (choice < 1 || choice > 9) {
//			showOptions();
//			submit();
//			System.out.println("passato da qui");
			MainDispatcher.getInstance().callView("NetworkManager", null);
		} else if (choice == 9) {
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else if (request.getString("UsernameModificaUtente") != null) {
			MainDispatcher.getInstance().callAction("NetworkManager", "doControl", request);
		} else {
			Request request = new Request();
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("NetworkManager", "doControl", request);
		}
	}
}
