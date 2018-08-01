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
	private HttpSession session;

	public ModifyProfileServlet() {
		this.utenteService = new UtenteService();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.request = req;
		this.response = resp;
		//HttpSession session = this.request.getSession(true);
		String mode = this.request.getParameter("mode");

		// this.userLoggato= (Utente) session.getAttribute("UserLoggato");
		// String usernameLoggato = this.userLoggato.getUsername();

		if (mode != null) {
			switch (mode) {

			case "ModificaProfiloPersonale":
				getServletContext().getRequestDispatcher("/modifyProfile.jsp").forward(this.request, resp);
				break;

//			case "ModificaProfiloPersonaleNetworkManager":
//				getServletContext().getRequestDispatcher("/modifyProfile.jsp").forward(this.request, resp);
//				break;
//
//			case "ModificaProfiloPersonaleUser":
//				getServletContext().getRequestDispatcher("/modifyProfile.jsp").forward(this.request, resp);
//				break;

			case "ModifyProfile":
				modifyProfile();
				break;
			}
		}
	}

	private void modifyProfile() {
		Utente utente = (Utente) request.getSession().getAttribute("UserLoggato");

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
