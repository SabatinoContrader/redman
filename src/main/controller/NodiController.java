package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Nodo;
import main.service.NodoService;

public class NodiController implements Controller {
	private NodoService nodoService;
	private Request request;
	private String mode;

	@Override
	public void doControl(Request request) {
		this.nodoService = new NodoService();
		this.request = request;

		if (this.request.get("mode") != null) {
			mode = request.get("mode").toString();

			switch (mode) {
			case "creaNuovoNodo":
				creaNodo();
				break;
			case "visualizzaListaNodi":
				visualizzaListaNodi();
				break;
			case "back":
				Request newRequest=new Request();
				newRequest.put("UserLoggato", this.request.get("UserLoggato"));
				MainDispatcher.getInstance().callAction("Home", "doControl", newRequest);
				break;
			}

		} else {
			MainDispatcher.getInstance().callView("Nodi", this.request);
		}
	}
	
	private void creaNodo() {
		Nodo nodo = (Nodo) this.request.get("NuovoNodo");
		if (this.nodoService.insertNodo(nodo)) {
			System.out.println("Nuovo nodo Aggiunto con successo\n");
		} else {
			System.out.println("Nodo già presente nel sistema");
		}
		MainDispatcher.getInstance().callView("Nodi", this.request);
	}

	private void assegnaNodi() {

	}

	private void cancellaNodo() {

	}

	private void visualizzaListaNodi() {
		List<Nodo> nodi = nodoService.getAllnodi();
		this.request.put("listaNodi", nodi);
		MainDispatcher.getInstance().callView("Nodi", this.request);
	}

}
