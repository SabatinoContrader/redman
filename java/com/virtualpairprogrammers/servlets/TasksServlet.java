package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Nodo;
import com.virtualpairprogrammers.model.Task;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.TaskService;
import com.virtualpairprogrammers.services.UtenteService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TasksServlet extends HttpServlet {

	private TaskService taskService;
	private UtenteService utenteService;
	private HttpServletRequest request;
    private Utente userLoggato;
    private List<Task> listatask;

	public TasksServlet() {
		this.taskService = new TaskService();
		this.utenteService = new UtenteService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		
		HttpSession session = this.request.getSession(true);
		String mode = this.request.getParameter("mode");
		this.userLoggato= (Utente) session.getAttribute("UserLoggato");
		
		if (mode != null) {
			switch (mode) {
			case "GestioneTaskNetworkManager":
				visualizzaListaTasks();
				getServletContext().getRequestDispatcher("/networkManager/TasksManagementNetworkManager.jsp").forward(this.request, response);
				break;
			case "SegnalaFaultTask":
				System.out.println("FAULT");
				getServletContext().getRequestDispatcher("/networkManager/TasksManagementNetworkManager.jsp").forward(this.request, response);
				break;
			case "Visualizza segnalazioni":
//				visualizzaListaTasks();
//				getServletContext().getRequestDispatcher("/user/TasksListUser.jsp").forward(this.request, response);
				break;
			case "SospendiTask":
				System.out.println("SOSPENDI");
				getServletContext().getRequestDispatcher("/networkManager/TasksManagementNetworkManager.jsp").forward(this.request, response);
				break;
			case "Associa":
				associaTasks();
				getServletContext().getRequestDispatcher("/networkManager/TasksManagementNetworkManager.jsp").forward(this.request, response);
				break;
			case "indietroNM":
				getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(this.request,response);
				break;

			}
		}

	}

	private void visualizzaListaTasks() {
		int idutente=utenteService.getidUtente(userLoggato.getUsername());
		listatask = taskService.getTasksNM(idutente);
		this.request.setAttribute("listaTasks", listatask);
	}
	
	private void associaTasks() {
//		for(Task task:listatask) {
//			String parameter="nodo_"+task.getIdtask();
//			String idnodo = (String) this.request.getParameter(parameter);
//			if(usernameResponsabile.equals("")) {
//				nodoService.UtenteNodo(-1, nodo.getIdnodo());
//			}else {
//				int idUtente=utenteService.getidUtente(usernameResponsabile);
//				nodoService.UtenteNodo(idUtente, nodo.getIdnodo());
//			}
//			
//		}
//		visualizzaListaTasks();
	}

}
