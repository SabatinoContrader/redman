package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.UtenteService;

public class ModifyProfileServlet extends HttpServlet {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private UtenteService utenteService;
	private Utente userLoggato;

	public ModifyProfileServlet() {
		this.utenteService = new UtenteService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		HttpSession session = this.request.getSession(true);
		String mode = this.request.getParameter("mode");		
		if (mode != null) {
			switch (mode) {
			case "back":
				back(session);
				break;
			case "ModificaProfiloPersonale":
				getServletContext().getRequestDispatcher("/modifyProfile.jsp").forward(this.request, this.response);
				break;

//			case "ModificaProfiloPersonaleNetworkManager":
//				getServletContext().getRequestDispatcher("/modifyProfile.jsp").forward(this.request, resp);
//				break;
//
//			case "ModificaProfiloPersonaleUser":
//				getServletContext().getRequestDispatcher("/modifyProfile.jsp").forward(this.request, resp);
//				break;

			case "ModifyProfile":
				modifyProfile(session);
				break;
			}
		}
	}

	private void back(HttpSession session) throws ServletException, IOException {
		Utente userLoggato = (Utente) session.getAttribute("UserLoggato");
		if (userLoggato.getRuolo().equalsIgnoreCase("amministratore")) {
			getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(this.request, this.response);;
		} else if (userLoggato.getRuolo().equalsIgnoreCase("responsabile di rete")) {
			getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(this.request, this.response);;
		} else if (userLoggato.getRuolo().equalsIgnoreCase("utente semplice")) {		
			getServletContext().getRequestDispatcher("/user/user.jsp").forward(this.request, this.response);;
		}
	}
	
	private void modifyProfile(HttpSession session) {
		Utente utente = (Utente) this.request.getSession().getAttribute("UserLoggato");

		String nuovaUsername = this.request.getParameter("username");
		String nuovaPassword = this.request.getParameter("password");
		String ruolo = utente.getRuolo();

		Utente nuoviDati = new Utente(nuovaUsername, nuovaPassword);

		String VecchiaUsername = utente.getUsername();

		if (utenteService.setUtente(nuoviDati, VecchiaUsername)) {
			System.out.println("\nProfilo modificato Correttamente!");
			session= this.request.getSession();
			session.setAttribute("UserLoggato", new Utente(ruolo,nuovaUsername,nuovaPassword));
			callView(ruolo);
		} else {
			System.out.println("\nErrore nella modifica del profilo!");
		}

	}

	private void callView(String ruolo) {

		try {
			switch (ruolo) {
			case "amministratore":
				getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(this.request, this.response);
				break;
			case "responsabile di rete":
				getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(this.request, this.response);
				break;
			case "utente semplice":
				getServletContext().getRequestDispatcher("/user/user.jsp").forward(this.request, this.response);
				break;
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
