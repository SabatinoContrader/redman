package main.view.user;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Utente;
import main.view.View;

public class UserView implements View {
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
		System.out.println("\n--------MENU--------");
		System.out.println("*******UTENTE*******\n");
		System.out.println("1) Visualizza stato nodi");
		System.out.println("2) Visualizza segnalazioni");
		System.out.println("3) Modifica profilo personale");
		System.out.println("4) Logout");
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
			this.request.put("mode", "VisualizzaStatoNodiUser");
			break;
		case 2:
			this.request.put("mode", "VisualizzaSegnalazioniUser");
			break;
		case 3:
			this.request.put("mode", "logout");
			break;
		case 4:
			this.request.put("mode", "modificaProfiloPersonale");
			break;
		default:
			this.request.put("mode", "callUserView");
			break;
		}
		MainDispatcher.getInstance().callAction("Home", "doControl", this.request);
	}

}
