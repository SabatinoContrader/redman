package main.view;

import java.util.List;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Task;
import main.model.Utente;

public class TasksView implements View {
	private Request request;

	@Override
	public void showResults(Request request) {
		this.request = request;

		if (this.request.get("modeTasks").equals("visualizzaTasksNodiNetworkManager")) {
			List<Task> ListaTasks = (List<Task>) this.request.get("listaTasks");
			for (Task task : ListaTasks) {
				System.out.println(task);
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

	public void submit() {		
		Utente UserLoggato = (Utente) this.request.get("UserLoggato");
		Request newRequest = new Request();
		newRequest.put("UserLoggato", UserLoggato);

		switch (UserLoggato.getRuolo()) {
		case "amministratore":
			//newRequest.put("modeNodi", "callNodesManagementAdminView");
			//MainDispatcher.getInstance().callAction("Nodes", "doControl", newRequest);
			break;
		case "responsabile di rete":
			newRequest.put("modeTasks", "callTasksManagementNetworkManagerView");
			MainDispatcher.getInstance().callAction("Tasks", "doControl", newRequest);
			break;
		case "utente semplice":
			//MainDispatcher.getInstance().callView("user.User", newRequest);
			break;
		}
			
	}
}	
