package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Nodo;
import main.model.Utente;

public class AdminView implements View {

	private int choice;

	@Override
	public void showResults(Request request) {

		if (request != null) {
			if (request.get("mode") == "VisualizzaListaUtenti") {
				List<Utente> listaUtenti = (List<Utente>) request.get("listaUtenti");
				for (Utente utente : listaUtenti) {
					System.out.println(utente);
				}
			}
			
			if(request.get("mode")=="VisualizzaListaNodi") {
				List<Nodo> listaNodi=(List<Nodo>) request.get("listaNodi");
				for(Nodo nodo:listaNodi) {
					System.out.println(nodo);
				}
			}
		}
		
			
	}

	@Override
	public void showOptions() {
		System.out.println("---------MENU---------");
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
		this.choice = Integer.parseInt(getInput());
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		Request request = new Request();
		// request.put("choice", choice);
		// MainDispatcher.getInstance().callAction("", "doControl", request);

		if (choice < 1 || choice > 9) {
			showOptions();
			submit();
		} else if (choice == 9) {
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else {
			switch (choice) {
			case 1: {
				request.put("mode", "insert");
				System.out.println("Nome utente:");
				String nomeUtente = getInput();
				System.out.println("Password:");
				String password = getInput();
				System.out.println("Ruolo:");
				String ruolo = getInput();
				Utente utente = new Utente(ruolo, nomeUtente, password);
				request.put("NuovoUtente", utente);
				MainDispatcher.getInstance().callAction("Admin", "doControl", request);
			}
				break;
			case 4: {
				request.put("mode", "insertnodo");
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
			case 7: {
				request.put("mode", "VisualizzaListaNodi");
				MainDispatcher.getInstance().callAction("Admin", "doControl", request);

			}
			break;	
			case 8: {
				request.put("mode", "VisualizzaListaUtenti");
				MainDispatcher.getInstance().callAction("Admin", "doControl", request);

			}
			}

		}
	}
}
