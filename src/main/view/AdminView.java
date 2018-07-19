package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class AdminView implements View {

	private int choice;

	@Override
	public void showResults(Request request) {

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
		if (choice < 1 || choice > 9) {
			showOptions();
			submit();
		} else if (choice == 9) {
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
        }
	}
}
