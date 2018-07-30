package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Utente;
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

public class UtentiServlet extends HttpServlet {
	private UtenteService utenteService;
	private HttpServletRequest request;
	
	public UtentiServlet() {
		utenteService= new UtenteService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//super.service(req, resp);
		
		this.request=req;
		visualizzaListaUtenti();
		getServletContext().getRequestDispatcher("/admin/gestioneUtentiAdmin.jsp").forward(this.request, resp);

	}

	private void visualizzaListaUtenti() {
		List<Utente> UtentiList = utenteService.getAllUtenti();
		this.request.setAttribute("listaUtenti", UtentiList);
	}

}
