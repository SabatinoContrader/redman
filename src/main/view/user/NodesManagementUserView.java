package main.view.user;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Nodo;
import main.view.View;

public class NodesManagementUserView implements View {
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
		System.out.println("\n1) Visualizza stato nodi");
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
			this.request.put("modeNodi", "VisualizzaStatoNodiUser");
			break;
		case 2:
			this.request.put("modeNodi", "back");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("modeNodi", "callNodesManagementUserView");
			break;
		}
		MainDispatcher.getInstance().callAction("Nodes", "doControl", this.request);
	}

}
