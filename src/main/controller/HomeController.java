package main.controller;

import main.MainDispatcher;

public class HomeController implements Controller {

	private Request request;

	public HomeController() {
		

	}

	public void doControl(Request request) {
		this.request = request;
		String mode;
		if (this.request.get("mode") != null) {
			mode = this.request.get("mode").toString();
			switch (mode) {
			case "gestioneUtentiAdmin":
				MainDispatcher.getInstance().callView("admin.UsersManagementAdmin", this.request);
				break;
			case "gestioneNodiAdmin":
				MainDispatcher.getInstance().callView("admin.NodesManagementAdmin", this.request);
				break;
			case "callAdminView":
				MainDispatcher.getInstance().callView("admin.Admin", this.request);
				break;
			case "gestioneUtentiNetworkManager":
				MainDispatcher.getInstance().callView("networkManager.UsersManagementNetworkManager", this.request);
				break;
			case "gestioneNodiNetworkManager":
				MainDispatcher.getInstance().callView("networkManager.NodesManagementNetworkManager", this.request);
				break;
			case "gestioneTaskNetworkManager":
				MainDispatcher.getInstance().callView("networkManager.TasksManagementNetworkManager", this.request);
				break;
			case "callNetworkManagerView":
				MainDispatcher.getInstance().callView("networkManager.NetworkManager", this.request);
				break;
			case "VisualizzaStatoNodiUser":
				break;
			case "VisualizzaSegnalazioniUser":
				break;
			case "callUserView":
				MainDispatcher.getInstance().callView("user.User", this.request);
				break;
			case "modificaProfiloPersonale":
				MainDispatcher.getInstance().callView("ModifyProfile", this.request);
				break;
			case "logout":
				MainDispatcher.getInstance().callAction("Login", "doControl", null);
				break;
			}
		}
	}

	
}
