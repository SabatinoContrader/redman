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
	private HttpServletResponse response;
//	public UtentiServlet() {
//		this.utenteService= new UtenteService();
//	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.request = req;
		this.response = resp;
		HttpSession session = this.request.getSession(true);
		String modeUtenti = this.request.getParameter("modeUtenti");
		if (modeUtenti != null) {
			switch (modeUtenti) {
			case "back":
				back(session);
				break;
			}
				
		}
		
//		visualizzaListaUtenti();
//		getServletContext().getRequestDispatcher("/admin/gestioneUtentiAdmin.jsp").forward(this.request, resp);

	}
	
	private void back(HttpSession session) throws ServletException, IOException {
		Utente userLoggato = (Utente) session.getAttribute("UserLoggato");
		System.out.println(userLoggato.getRuolo().toString());
		if (userLoggato.getRuolo().equalsIgnoreCase("amministratore")) {
			getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(this.request, this.response);;
		} else if (userLoggato.getRuolo().equalsIgnoreCase("responsabile di rete")) {
			getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(this.request, this.response);;
		} else if (userLoggato.getRuolo().equalsIgnoreCase("utente semplice")) {		
			getServletContext().getRequestDispatcher("/user/user.jsp").forward(this.request, this.response);;
		}
	}

	private void visualizzaListaUtenti() {
		List<Utente> UtentiList = utenteService.getAllUtenti();
		this.request.setAttribute("listaUtenti", UtentiList);
	}

}
