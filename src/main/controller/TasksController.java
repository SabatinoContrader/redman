package main.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.MainDispatcher;
import main.model.Task;
import main.model.Utente;
import main.service.TaskService;
import main.service.UtenteService;

public class TasksController implements Controller {
	private TaskService taskService;
	private UtenteService utenteService;
	private Request request;
	
	@Override
	public void doControl(Request request) {
		this.taskService = new TaskService();
		this.utenteService= new UtenteService();
		this.request = request;

		if (this.request.get("modeTasks") != null) {

			String modeTasks = request.get("modeTasks").toString();
			switch (modeTasks) {
			case "AssegnaNodiAdmin":
				break;			
			case "visualizzaTasksNodiNetworkManager":
				visualizzaListaTasks();
				callTasksView();
				break;
			case "callTasksManagementNetworkManagerView":
				MainDispatcher.getInstance().callView("networkManager.TasksManagementNetworkManager", this.request);
				break;		
			case "back":
				 back();
				break;
				
			}
			
		}

	
	}
	
	
	private void callTasksView() {
		MainDispatcher.getInstance().callView("Tasks", this.request);
			
	}

	private void visualizzaListaTasks() {
		List<Task> ListaTasks = taskService.getAllTasks();
		this.request.put("listaTasks", ListaTasks);
		//MainDispatcher.getInstance().callView("Tasks", this.request);
	}
	
	private void back() {
		Utente utente = (Utente) request.get("UserLoggato");
		if (utente.getRuolo().equals("amministratore")) {
			MainDispatcher.getInstance().callView("admin.Admin", this.request);
		} else if (utente.getRuolo().equals("responsabile di rete")) {
			MainDispatcher.getInstance().callView("networkManager.NetworkManager", this.request);
		}
	}
	

}
