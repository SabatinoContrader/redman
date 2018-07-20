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
		this.request = request;
		
		if(this.request==null) {
			MainDispatcher.getInstance().callView("Admin", null);
		}else {		
			int choice = (int) this.request.get("choice");
			
			switch (choice) {
				case 1: {
					aggiungiProfilo();
				}
					break;
				case 2: {
					canecellaProfilo();
				}
					break;
				case 3: {
					modificaProfiloPersonale();
				}
					break;
				case 4: {
					creaNodi();
				}
					break;
				case 5: {
					assegnaNodi();
				}
					break;
				case 6: {
					cancellaNodi();
				}
					break;
				case 7: {
					visualizzaListaNodi();
				}
					break;
				case 8: {
					visualizzaListaUtenti();
				}
					break;
			}
		}
	}

	private void aggiungiProfilo() {
		Utente utente = (Utente) request.get("NuovoUtente");
		if (this.utenteService.insertUtente(utente)) {
			System.out.println("Nuovo utente Aggiunto correttamente\n");
		} else {
			System.out.println("Utente già esistente");
		}
		MainDispatcher.getInstance().callView("Admin", null);
	}

	private void canecellaProfilo() {
		String nomeUtente = (String) request.get("CancellaUtente");
		if (this.utenteService.deleteUtente(nomeUtente)) {
			System.out.println("Utente \"" + nomeUtente + "\" Cancellato correttamente\n");
		} else {
			System.out.println("Utente \"" + nomeUtente + "\" non presente");
		}
		MainDispatcher.getInstance().callView("Admin", null);
	}

	private void modificaProfiloPersonale() {
		Utente nuoviDati = (Utente) request.get("UtenteModificato");
		String VecchiaUsername = request.get("UsernameAccesso").toString();

		if (utenteService.setUtente(nuoviDati, VecchiaUsername)) {
			System.out.println("\nProfilo modificato Correttamente!");
		} else {
			System.out.println("\nErrore nella modifica del profilo!");
		}
		utenteService.setUtente(nuoviDati, VecchiaUsername);
		MainDispatcher.getInstance().callView("Admin", null);
	}

	private void creaNodi() {
		Nodo nodo = (Nodo) request.get("NuovoNodo");
		if (this.nodoService.insertNodo(nodo)) {
			System.out.println("Nuovo nodo Aggiunto con successo\n");
		} else {
			System.out.println("Nodo già presente nel sistema");
		}
		MainDispatcher.getInstance().callView("Admin", null);
	}

	private void assegnaNodi() {

	}

	private void cancellaNodi() {

	}

	private void visualizzaListaNodi() {
		List<Nodo> nodi = nodoService.getAllnodi();
		request.put("mode", "visualizzaListaNodi");
		request.put("listaNodi", nodi);
		MainDispatcher.getInstance().callView("Admin", request);
	}

	private void visualizzaListaUtenti() {
		List<Utente> UtentiList = utenteService.getAllUtenti();
		request.put("mode", "visualizzaListaUtenti");
		request.put("listaUtenti", UtentiList);
		MainDispatcher.getInstance().callView("Admin", request);
	}

}
