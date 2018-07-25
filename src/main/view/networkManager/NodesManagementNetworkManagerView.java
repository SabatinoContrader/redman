package main.view.networkManager;

import java.util.Scanner;

import main.controller.Request;
import main.model.Nodo;
import main.view.View;

public class NodesManagementNetworkManagerView implements View {
	private Request request;
	private int choice;

	@Override
	public void showResults(Request request) {
		this.request = request;
	}

	@Override
	public void showOptions() {
		System.out.println("\n1) Visualizza il tuo blocco di nodi");
		System.out.println("2) Visualizza lo stato dei tuoi nodi");
		System.out.println("3) visualizza le informazioni dei tuoi nodi");
		System.out.println("4) Indietro");
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
			this.request.put("modeNodi", "visualizzaNodiNetworkManager");
			break;
		case 2:
			this.request.put("modeNodi", "visualizzaStatoNodiNetworkManager");
			break;
		case 3:
			this.request.put("modeNodi", "visualizzaInfoNodiNetworkManager");
			break;
		case 4:
			this.request.put("modeNodi", "back");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("modeNodi", "callNodesManagementNetworkManagerView");
			break;
		}
				
	}

}
