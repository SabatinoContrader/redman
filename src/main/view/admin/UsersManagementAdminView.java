package main.view.admin;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;
import main.view.View;

public class UsersManagementAdminView implements View {
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
		System.out.println("\n1) Aggiungi profilo");
		System.out.println("2) Cancella profilo");
		System.out.println("3) Visualizza lista utenti");
		System.out.println("4) Indietro");
		// choice = Integer.parseInt(getInput());
		this.choice = Integer.parseInt(getInput());
		
		if (choice == 1) {
			System.out.println("Nome utente:");
			String nomeUtente = getInput();
			System.out.println("Password:");
			String password = getInput();
			System.out.println("Ruolo:");
			String ruolo = getInput();
			Utente utente = new Utente(ruolo, nomeUtente, password);
			this.request.put("nuovoUtente", utente);
			//this.request.put("mode", "aggiungiUtente");
		} else if (choice == 2) {
			System.out.println("Inserisci nome utente da cancellare:");
			String nomeUtente = getInput();
			this.request.put("cancellaUtente", nomeUtente);
//			this.request.put("mode", "cancellaUtente");

		}
		
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
		switch (this.choice) {
		case 1:
			this.request.put("modeUtenti", "aggiungiProfiloAdmin");
			break;
		case 2:
			this.request.put("modeUtenti", "cancellaProfiloAdmin");
			break;
		case 3:
			this.request.put("modeUtenti", "visualizzaListaUtentiAdmin");
			break;
		case 4:
			this.request.put("modeUtenti", "back");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("modeUtenti", "callUsersManagementAdminView");
			break;
		}
		MainDispatcher.getInstance().callAction("Utenti", "doControl", this.request);
	}

}
