package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Nodo;
import main.model.Utente;

public class AdminView implements View {

	private int choice;
	private boolean b = true;
	Request request = new Request();

	@Override
	public void showResults(Request request) {
		this.request = request;
		if (this.request != null) {
			if (this.request.get("mode") != null) {
				if (this.request.get("mode") == "visualizzaListaUtenti") {
					List<Utente> listaUtenti = (List<Utente>) request.get("listaUtenti");
					for (Utente utente : listaUtenti) {
						System.out.println(utente);
					}
				}

				if (this.request.get("mode") == "visualizzaListaNodi") {
					List<Nodo> listaNodi = (List<Nodo>) this.request.get("listaNodi");
					for (Nodo nodo : listaNodi) {
						System.out.println(nodo);
					}
				}
			}
		}
	}

	@Override
	public void showOptions() {
		System.out.println("\n---------MENU---------");
		System.out.println("****AMMINISTRATORE****\n");
		System.out.println("1) Aggiungi profilo");
		System.out.println("2) Cancella profilo");
		System.out.println("3) Modifica profilo personale");
		System.out.println("4) Crea nodi");
		System.out.println("5) Assegna nodi");
		System.out.println("6) Cancella nodi");
		System.out.println("7) Visualizza lista nodi");
		System.out.println("8) Visualizza lista utenti");
		System.out.println("9) Logout");
		try {
			this.choice = Integer.parseInt(getInput());
		} catch (NumberFormatException n) {
			b = false;
		}

		if (this.choice == 3) {
			System.out.println("Inserisci nuovo username: ");
			String nuovoUsername = getInput();
			System.out.println("Inserisci nuova password: ");
			String nuovaPassword = getInput();

			Utente utenteModificato = new Utente(nuovoUsername, nuovaPassword);
			this.request.put("UtenteModificato", utenteModificato);
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {

		if (choice < 1 || choice > 9 || b == false) {
			System.out.println("Inserimento sbagliato");
			MainDispatcher.getInstance().callAction("Admin", "doControl", null);
		} else if (choice == 9) {
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else {
			this.request.put("choice", choice);
			switch (choice) {
			case 1: {
				System.out.println("Nome utente:");
				String nomeUtente = getInput();
				System.out.println("Password:");
				String password = getInput();
				System.out.println("Ruolo:");
				String ruolo = getInput();
				Utente utente = new Utente(ruolo, nomeUtente, password);
				this.request.put("NuovoUtente", utente);
				MainDispatcher.getInstance().callAction("Admin", "doControl", this.request);
			}
			case 2: {
				System.out.println("Nome utente:");
				String nomeUtente = getInput();
				this.request.put("CancellaUtente", nomeUtente);
				MainDispatcher.getInstance().callAction("Admin", "doControl", this.request);
			}
				break;
			case 3: {
				MainDispatcher.getInstance().callAction("Admin", "doControl", this.request);
			}
				break;
			case 4: {
				// request.put("mode", "insertnodo");
				System.out.println("Id nodo:");
				int idnodo = Integer.parseInt(getInput());
				System.out.println("Info nodo:");
				String infonodo = getInput();
				System.out.println("Stato nodo:");
				String statonodo = getInput();
				System.out.println("Gruppi id gruppo:");
				int gruppi_idgruppo = Integer.parseInt(getInput());
				Nodo nodo = new Nodo(idnodo, infonodo, statonodo, gruppi_idgruppo);
				request.put("NuovoNodo", nodo);
				MainDispatcher.getInstance().callAction("Admin", "doControl", request);
			}
				break;
			case 5: {

			}
				break;
			case 6: {

			}
				break;
			case 7: {
				MainDispatcher.getInstance().callAction("Admin", "doControl", request);

			}
				break;
			case 8: {
				MainDispatcher.getInstance().callAction("Admin", "doControl", request);

			}
			}

		}
	}
}
