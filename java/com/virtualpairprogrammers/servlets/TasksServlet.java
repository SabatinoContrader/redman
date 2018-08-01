package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Task;
import com.virtualpairprogrammers.services.TaskService;

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
	private HttpServletRequest request;

public TasksServlet() {
	taskService= new TaskService();
}

@Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//super.service(req, resp);
	
	this.request=request;
	visualizzaListaTasks();
	getServletContext().getRequestDispatcher("/networkManager/TasksManagementNetworkManager.jsp").forward(this.request, response);

}

private void visualizzaListaTasks() {
	List<Task> listatask = taskService.getAllTasks();
	this.request.setAttribute("listaTasks", listatask);
	}
}
	