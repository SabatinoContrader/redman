package main.view.networkManager;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;
import main.view.View;

public class NetworkManagerView implements View {
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
		this.request = request;
	}

	@Override
	public void showOptions() {
		System.out.println("\n--------MENU--------");
		System.out.println("****RESPONSABILE****\n");
		System.out.println("1) Gestione utenti");
		System.out.println("2) Gestione nodi");
		System.out.println("3) Gestione task");
		System.out.println("4) Modifica profilo personale");
		System.out.println("5) Logout");
		this.choice = Integer.parseInt(getInput());
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
			this.request.put("mode", "gestioneUtentiNetworkManager");
			break;
		case 2:
			this.request.put("mode", "gestioneNodiNetworkManager");
			break;
		case 3:
			this.request.put("mode", "gestioneTaskNetworkManager");
			break;
		case 4:
			this.request.put("mode", "modificaProfiloPersonale");
			break;
		case 5:
			this.request.put("mode", "logout");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("mode", "callNetworkManagerView");
			break;
		}
		MainDispatcher.getInstance().callAction("Home", "doControl", this.request);
	}

}
