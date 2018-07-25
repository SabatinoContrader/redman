package main.view.networkManager;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.view.View;

public class TasksManagementNetworkManagerView implements View{
	private Request request;
	private int choice;
	
	@Override
	public void showResults(Request request) {
		this.request = request;

	}

	@Override
	public void showOptions() {
		System.out.println("\n1) Visualizza i task in esecuzione sui tuoi nodi");
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
			this.request.put("modeTasks", "visualizzaTasksNodiNetworkManager");
			break;
		case 2:
			this.request.put("modeTasks", "back");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("modeTasks", "callTasksManagementNetworkManagerView");
			break;
		}
		MainDispatcher.getInstance().callAction("Tasks", "doControl", this.request);
		
	}


}


