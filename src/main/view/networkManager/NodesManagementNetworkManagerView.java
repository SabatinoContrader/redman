package main.view.networkManager;

import java.util.Scanner;

import main.MainDispatcher;
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
		System.out.println("3) Visualizza le informazioni dei tuoi nodi");
		System.out.println("4) Associa nodi agli utenti");
		System.out.println("5) Cancella associazioni nodi");
		System.out.println("6) Visualizzare associazioni di nodi");
		System.out.println("7) Indietro");
       
		
		//System.out.println(") Indietro");
		this.choice = Integer.parseInt(getInput());
        if (choice==4) {        	
        	System.out.println("Inserisci username utente:");
			String usernameNodi = getInput();
			System.out.println(" Inserisci i nodi da associare all'utente (separati da \";\")");
			String idNodi = getInput();
			this.request.put("usernameNodi",usernameNodi);
			this.request.put("idNodi",idNodi);
        } else if (choice==5) {        	
			System.out.println(" Inserisci i nodi da disassociare (separati da \";\")");
			String idNodi = getInput();
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
			this.request.put("modeNodi", "visualizzaNodiNetworkManager");
			break;
		case 2:
			this.request.put("modeNodi", "visualizzaStatoNodiNetworkManager");
			break;
		case 3:
			this.request.put("modeNodi", "visualizzaInfoNodiNetworkManager");
			break;
		case 4:
			this.request.put("modeNodi", "associaNodiNetworkManager");
			break;
		case 5:
			this.request.put("modeNodi", "disassociaNodiNetworkManager");
			break;
		case 6:
			this.request.put("modeNodi", "visualizzaAssociazioniNodiNetworkManager");
			break;
		case 7:
			this.request.put("modeNodi", "back");
			break;
		default:
			System.out.println("Scelta errata!!");
			this.request.put("modeNodi", "callNodesManagementNetworkManagerView");
			break;
		}
		MainDispatcher.getInstance().callAction("Nodes", "doControl", this.request);	
	}

}
