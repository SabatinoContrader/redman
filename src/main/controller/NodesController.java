package main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.MainDispatcher;
import main.model.Nodo;
import main.model.Utente;
import main.service.NodoService;
import main.service.UtenteService;

public class NodesController implements Controller {
	private NodoService nodoService;
	private UtenteService utenteService;
	private Request request;
	
	@Override
	public void doControl(Request request) {
		this.nodoService = new NodoService();
		this.utenteService= new UtenteService();
		this.request = request;

		if (this.request.get("modeNodi") != null) {

			String modeNodi = request.get("modeNodi").toString();
			switch (modeNodi) {
			case "creaNodoAdmin":
				creaNodo();
				callView(); 
				break;
			case "AssegnaNodiAdmin":
				break;
			case "cancellaNodiAdmin":
				break;			
			case "visualizzaListaNodiAdmin":
				visualizzaListaNodi();
				break;
			case "callNodesManagementAdminView":
				callView();
				break;	
			case "visualizzaNodiNetworkManager":
				break;			
			case "visualizzaStatoNodiNetworkManager":
				visualizzaListaNodi();
				break;
			case "visualizzaInfoNodiNetworkManager":
				callView();
				break;	
			case "associaNodiNetworkManager":
				associaNodiUtenti();
				callView();
				break;
			case "disassociaNodiNetworkManager":
				break;
			case "visualizzaAssociazioniNodiNetworkManager":
				break;
			case "back":
				 back();
				break;
				
			}
			
		}

	}
	
	private void creaNodo() {
		Nodo nodo = (Nodo) this.request.get("NuovoNodo");
		if (this.nodoService.insertNodo(nodo)) {
			System.out.println("Nuovo nodo Aggiunto con successo\n");
		} else {
			System.out.println("Nodo già presente nel sistema");
		}
	}
	
	private void callView() {
		Utente UserLoggato = (Utente) this.request.get("UserLoggato");
		Request newRequest = new Request();
		newRequest.put("UserLoggato", UserLoggato);

		switch (UserLoggato.getRuolo()) {
		case "amministratore":
			MainDispatcher.getInstance().callView("admin.NodesManagementAdmin", newRequest);
			break;
		case "responsabile di rete":
			MainDispatcher.getInstance().callView("networkManager.NodesManagementNetworkManager", newRequest);
			break;
		}
	}
	
	private void visualizzaListaNodi() {
		List<Nodo> nodi = nodoService.getAllnodi();
		this.request.put("listaNodi", nodi);
		MainDispatcher.getInstance().callView("Nodes", this.request);
	}
	
	private void back() {
		Utente utente = (Utente) request.get("UserLoggato");
		if (utente.getRuolo().equals("amministratore")) {
			MainDispatcher.getInstance().callView("admin.Admin", this.request);
		} else if (utente.getRuolo().equals("responsabile di rete")) {
			MainDispatcher.getInstance().callView("networkManager.NetworkManager", this.request);
		}
	}
	
	private void associaNodiUtenti() {
		List<String> ListaIdnodi; 
		String idNodi=this.request.get("idNodi").toString();
		String UsernameNodi=this.request.get("usernameNodi").toString();
		
		int idUtente=utenteService.getidUtente(UsernameNodi);
		
		ListaIdnodi=Arrays.asList(idNodi.split(";"));
		
		for(String idNodo:ListaIdnodi) {
			nodoService.UtenteNodo(idUtente, Integer.valueOf(idNodo));
		}
		System.out.println("Nodi Associati con successo");		
	}
	
}
