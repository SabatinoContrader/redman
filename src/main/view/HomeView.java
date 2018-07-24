package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;

public class HomeView implements View {
	private Request request;
	private int choice;
	private Utente utente;

	@Override
	public void showResults(Request request) {
		this.request = request;
	}

	@Override
	public void showOptions() {
		utente = (Utente) this.request.get("UserLoggato");

		if (utente.getRuolo().equals("amministratore")) {
			System.out.println("\n---------MENU---------");
			System.out.println("****AMMINISTRATORE****\n");
			System.out.println("1) Gestione utenti");
			System.out.println("2) Gestione nodi");
			System.out.println("3) Modifica profilo personale");
			System.out.println("4) Logout");
		} else if (utente.getRuolo().equals("responsabile di rete")) {
			System.out.println("\n--------MENU--------");
			System.out.println("****RESPONSABILE****\n");
			System.out.println("1) Gestione utenti");
			System.out.println("2) Gestione nodi");
			System.out.println("3) Gestione task");
			System.out.println("4) Modifica profilo personale");
			System.out.println("5) Logout");
		} else if (utente.getRuolo().equals("utente semplice")) {
			System.out.println("\n--------MENU--------");
			System.out.println("*******UTENTE*******\n");
			System.out.println("1) Visualizza stato nodi");
			System.out.println("2) Visualizza segnalazioni");
			System.out.println("3) Modifica profilo personale");
			System.out.println("4) Logout");
		}

		this.choice = Integer.parseInt(getInput());
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		if (utente.getRuolo().equals("amministratore")) {
			switch (this.choice) {
			case 1:
				GestioneUtenti();
				break;
			case 2:
				GestioneNodi();
				break;
			case 3:
				ModificaProfiloView();
				ModificaProfilo();
				break;
			case 4:
				Logout();
				break;
			}

		} else if (utente.getRuolo().equals("responsabile di rete")) {
			switch (this.choice) {
			case 1:
				GestioneUtenti();
				break;
			case 2:
				GestioneNodi();
				break;
			case 3:
				break;
			case 4:
				ModificaProfiloView();
				ModificaProfilo();
				break;
			case 5:
				Logout();
				break;
			}

		} else if (utente.getRuolo().equals("utente semplice")) {
			switch (this.choice) {
			case 1:
				GestioneNodi();
				break;
			case 2:
				break;
			case 3:
				ModificaProfiloView();
				ModificaProfilo();
				break;
			case 4:
				Logout();
				break;
			}

		}
	}

	private void GestioneUtenti() {
		MainDispatcher.getInstance().callAction("Utenti", "doControl", this.request);
	}

	private void ModificaProfiloView() {
		System.out.println("Inserisci nuovo username: ");
		String nuovoUsername = getInput();
		System.out.println("Inserisci nuova password: ");
		String nuovaPassword = getInput();
		
		Utente utenteModificato = new Utente(utente.getRuolo(),nuovoUsername, nuovaPassword);
		this.request.put("UtenteModificato", utenteModificato);
		this.request.put("mode", "modificaUtente");
	}

	private void ModificaProfilo() {
		MainDispatcher.getInstance().callAction("Home", "doControl", this.request);
	}

	private void GestioneNodi() {
		MainDispatcher.getInstance().callAction("Nodi", "doControl", this.request);
	}

	private void Logout() {
		MainDispatcher.getInstance().callAction("Login", "doControl", this.request);
	}

}
