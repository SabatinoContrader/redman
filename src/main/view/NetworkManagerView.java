package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.List;
import java.util.Scanner;

public class NetworkManagerView implements View{
	
	private int choice;

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		    System.out.println("Salve Responsabile di Rete");
	        System.out.println("Seleziona ciò che vuoi fare ");
	        System.out.println("");
	        System.out.println("");
	        System.out.println("-------MENU-------");
	        System.out.println("---RESPONSABILE---");
	        System.out.println("");
	        System.out.println("1) Visualizza il tuo blocco di nodi");
	        System.out.println("2) Visualuzza il tuo profilo");
	        System.out.println("3) Modifica il tuo profilo");
	        System.out.println("4) Visualizza lo stato dei tuoi nodi");
	        System.out.println("5) visualizza le informazioni dei tuoi nodi");
	        System.out.println("6) Visualizza le task associate ai tuoi nodi");
	        System.out.println("7) Visualizza lo stato dei tuoi task");
	        System.out.println("8) Visualizza utenti associati ai tuoi nodi");
	        System.out.println("9) logout");
	        this.choice = Integer.parseInt(getInput());
	}
	 
	 public void submit() {
	        if (choice < 1 || choice > 9)
	            MainDispatcher.getInstance().callAction("Login", "doControl", null);
	        else if (choice == 9)
	            MainDispatcher.getInstance().callAction("Login", "doControl", null);
	        else {
	            Request request = new Request();
	            request.put("choice", choice);
	            MainDispatcher.getInstance().callAction("NetworkManager", "doControl", request);
	        }
	    }


	    public String getInput() {
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
	    }



}
