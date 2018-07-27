package main.view.admin;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Nodo;
import main.view.View;

public class NodesManagementAdminView implements View {
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
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
		}else if (choice==2) {        	
        	System.out.println("Inserisci username responsabile:");
			String usernameResponsabileNodi = getInput();
			System.out.println(" Inserisci i nodi da associare all'utente (separati da \";\")");
			String idNodi = getInput();
			this.request.put("usernameResponsabileNodi",usernameResponsabileNodi);
			this.request.put("idNodi",idNodi);
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
			this.request.put("modeNodi", "creaNodoAdmin");
			break;
		case 2:
			this.request.put("modeNodi", "AssegnaNodiAdmin");
			break;
		case 3:
			this.request.put("modeNodi", "cancellaNodiAdmin");
			break;
		case 4:
			this.request.put("modeNodi", "visualizzaListaNodiAdmin");
			break;
		case 5:
			this.request.put("modeNodi", "back");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("modeNodi", "callNodesManagementAdminView");
			break;
		}
		MainDispatcher.getInstance().callAction("Nodes", "doControl", this.request);
	}

}
