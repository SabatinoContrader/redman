package main.view.networkManager;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.view.View;

public class UsersManagementNetworkManagerView implements View {
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
		System.out.println("\n1) Visualizza utenti associati ai tuoi nodi");
		System.out.println("2) Indietro");
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
			this.request.put("modeUtenti", "visualizzaUtentiNodiNetworkManager");
			break;
		case 2:
			this.request.put("modeUtenti", "back");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("modeUtenti", "callUsersManagementNetworkManagerView");
			break;
		}
		MainDispatcher.getInstance().callAction("Utenti", "doControl", this.request);
	}

}
