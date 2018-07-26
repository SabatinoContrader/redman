package main.view;

import java.util.List;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Nodo;
import main.model.Utente;

public class NodesView implements View{
	private Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;

		if (this.request.get("modeNodi").equals("visualizzaListaNodiAdmin")) {
			List<Nodo> listaNodi = (List<Nodo>) this.request.get("listaNodi");
			for (Nodo nodo : listaNodi) {
				System.out.println(nodo);
			}
		}
		else if (this.request.get("modeNodi").equals("visualizzaNodiNetworkManager")) {
			List<Nodo>  nodiAssociati= (List<Nodo>) this.request.get("listaNodiNetworkManager");
			for (Nodo nodoAss : nodiAssociati) {
				System.out.println(nodoAss);
			}
			
		}
		
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void submit() {		
		Utente UserLoggato = (Utente) this.request.get("UserLoggato");
		Request newRequest = new Request();
		newRequest.put("UserLoggato", UserLoggato);

		switch (UserLoggato.getRuolo()) {
		case "amministratore":
			newRequest.put("modeNodi", "callNodesManagementAdminView");
			MainDispatcher.getInstance().callAction("Nodes", "doControl", newRequest);
			break;
		case "responsabile di rete":
			newRequest.put("modeNodi", "callNodesManagementNetworkManagerView");
			MainDispatcher.getInstance().callAction("Nodes", "doControl", newRequest);
			break;
		case "utente semplice":
			//MainDispatcher.getInstance().callView("user.User", newRequest);
			break;
		}
			
	}

}
