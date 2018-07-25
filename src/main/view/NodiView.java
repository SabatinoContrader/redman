package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Nodo;
import main.model.Utente;

public class NodiView implements View {
	private Request request;
	private int choice;
	private Utente utente;

	@Override
	public void showResults(Request request) {
		this.request = request;

		if (this.request.get("mode") == "visualizzaListaNodiAdmin") {
			List<Nodo> listaNodi = (List<Nodo>) this.request.get("listaNodi");
			for (Nodo nodo : listaNodi) {
				System.out.println(nodo);
			}
		}

	}

	@Override
	public void showOptions() {
		utente = (Utente) this.request.get("UserLoggato");
		if (utente.getRuolo().equals("amministratore")) {
			System.out.println("\n1) Crea nodo");
			System.out.println("2) Assegna nodi");
			System.out.println("3) Cancella nodi");
			System.out.println("4) Visualizza lista nodi");
			System.out.println("5) Indietro");
			this.choice = Integer.parseInt(getInput());

			if (choice == 1) {
				System.out.println("Info nodo:");
				String infonodo = getInput();
				System.out.println("Stato nodo:");
				String statonodo = getInput();
				System.out.println("Gruppo funzonalità:");
				int gruppi_idgruppo = Integer.parseInt(getInput());
				Nodo nodo = new Nodo(infonodo, statonodo, gruppi_idgruppo);
				request.put("NuovoNodo", nodo);
				this.request.put("mode", "creaNuovoNodo");
			} else if (choice == 2) {

			} else if (choice == 3) {

			} else if (choice == 4) {
				this.request.put("mode", "visualizzaListaNodi");
			} else if (choice == 5) {
				this.request.put("mode", "back");
			}

		} else if (utente.getRuolo().equals("responsabile di rete")) {
			System.out.println("\n1) Visualizza il tuo blocco di nodi");
			System.out.println("2) Visualizza lo stato dei tuoi nodi");
			System.out.println("3) visualizza le informazioni dei tuoi nodi");
			System.out.println("4) Indietro");
			this.choice = Integer.parseInt(getInput());
			
			if (choice == 1) {

			} else if (choice == 2) {

			} else if (choice == 3) {
				
			} else if (choice == 4) {
				this.request.put("mode", "back");
			}
		} else if (utente.getRuolo().equals("utente semplice")) {
			System.out.println("1) Visualizza stato nodi");
			System.out.println("2) Indietro");
			
			if (choice == 1) {

			}else if (choice == 2) {
				this.request.put("mode", "back");
			}
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Nodi", "doControl", this.request);
	}

}
