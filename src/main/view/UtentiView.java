package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;

public class UtentiView implements View {
	private Request request;
	private int choice;
	private Utente utente;

	@Override
	public void showResults(Request request) {
		this.request = request;
		
		if (this.request.get("mode") == "visualizzaListaUtenti") {
			List<Utente> listaUtenti = (List<Utente>) request.get("listaUtenti");
			for (Utente utente : listaUtenti) {
				System.out.println(utente);
			}
		}else if (this.request.get("mode") == "visualizzaUtentiNodi") {
			
		}
	}

	@Override
	public void showOptions() {
		utente = (Utente) this.request.get("UserLoggato");

		if (utente.getRuolo().equals("amministratore")) {
			System.out.println("\n1) Aggiungi profilo");
			System.out.println("2) Cancella profilo");
			System.out.println("3) Visualizza lista utenti");
			System.out.println("4) Indietro");
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
				this.request.put("mode", "aggiungiUtente");
			} else if (choice == 2) {
				System.out.println("Inserisci nome utente da cancellare:");
				String nomeUtente = getInput();
				this.request.put("cancellaUtente", nomeUtente);
				this.request.put("mode", "cancellaUtente");
			}else if(choice==3) {
				this.request.put("mode", "visualizzaListaUtenti");
			}else if(choice==4) {
				this.request.put("mode", "back");
			}
			
			
		} else if (utente.getRuolo().equals("responsabile di rete")) {
			System.out.println("\n1) Visualizza utenti associati ai tuoi nodi");
			System.out.println("2) Indietro");
			this.choice = Integer.parseInt(getInput());
			
			if(choice==1) {
				this.request.put("mode", "visualizzaUtentiNodi");
			}else if(choice==2) {
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
//		if(this.request.get("mode")=="back") {
//			Request newRequest=new Request();
//			newRequest.put("UserLoggato", this.request.get("UserLoggato"));
//			MainDispatcher.getInstance().callAction("Home", "doControl", newRequest);
//		}else {
			MainDispatcher.getInstance().callAction("Utenti", "doControl", this.request);

		//}
	}

	private void back() {
		MainDispatcher.getInstance().callAction("Home", "doControl", this.request);
	}

}
