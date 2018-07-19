package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {

	private int choice;

	public void showResults(Request request) {

	}

	public void showOptions() {
		System.out.println("--------MENU--------");
		System.out.println("*******UTENTE*******");
		System.out.println("");
		System.out.println("1) Visualizza stato nodi");
		System.out.println("2) Visualizza segnalazioni");
		System.out.println("3) Logout");
		this.choice = Integer.parseInt(getInput());

	}

	public void submit() {
		if (choice < 1 || choice > 3) {
			showOptions();
			submit();
		} else if (choice == 3) {
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
		} else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
        }
		// TODO Auto-generated method stub

	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
