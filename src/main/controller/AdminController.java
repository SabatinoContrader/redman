package main.controller;

import java.util.List;
import main.MainDispatcher;
import main.model.Nodo;
import main.model.Utente;
import main.service.NodoService;
import main.service.UtenteService;

public class AdminController implements Controller {
	private UtenteService utenteService;
	private NodoService nodoService;
	Request request = new Request();

	@Override
	public void doControl(Request request) {		
		this.utenteService = new UtenteService();
		this.nodoService = new NodoService();
		this.request=request;
		
		int choice = (int) this.request.get("choice");

		switch (choice) {
			case 1: {
				aggiungiProfilo(this.request);
			}
				break;
			case 2: {
				canecellaProfilo(this.request);
			}
				break;
			case 3: {
				modificaProfiloPersonale(this.request);
			}
				break;
			case 4: {
				creaNodi(this.request);
			}
				break;
			case 5: {
				assegnaNodi(this.request);
			}
				break;
			case 6: {
				canecellaNodi(this.request);
			}
				break;
			case 7: {
				visualizzaListaNodi(this.request);
			}
				break;
			case 8: {
				visualizzaListaUtenti(this.request);
			}
				break;
		}
	}

	private void aggiungiProfilo(Request request) {
		Utente utente = (Utente) request.get("NuovoUtente");
		if (utenteService.insertUtente(utente)) {
			System.out.println("Nuovo utente Aggiunto correttamente\n");
		} else {
			System.out.println("Utente già esistente");
		}
		MainDispatcher.getInstance().callView("Admin", null);
	}

	private void canecellaProfilo(Request request) {

	}

	private void modificaProfiloPersonale(Request request) {

	}

	private void creaNodi(Request request) {
		Nodo nodo = (Nodo) request.get("NuovoNodo");
		if (nodoService.insertNodo(nodo)) {
			System.out.println("Nuovo nodo Aggiunto con successo\n");
		} else {
			System.out.println("Nodo già presente nel sistema");
		}
		MainDispatcher.getInstance().callView("Admin", null);
	}

	private void assegnaNodi(Request request) {

	}

	private void canecellaNodi(Request request) {

	}

	private void visualizzaListaNodi(Request request) {
		List<Nodo> nodi = nodoService.getAllnodi();
		request.put("mode", "visualizzaListaNodi");
		request.put("listaNodi", nodi);
		MainDispatcher.getInstance().callView("Admin", request);
	}

	private void visualizzaListaUtenti(Request request) {
		List<Utente> UtentiList = utenteService.getAllUtenti();
		request.put("mode", "visualizzaListaUtenti");
		request.put("listaUtenti", UtentiList);
		MainDispatcher.getInstance().callView("Admin", request);
	}

}
