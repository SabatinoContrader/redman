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
	private Utente userLoggato;

	
	public UtentiServlet() {
		this.utenteService= new UtenteService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;
		HttpSession session = this.request.getSession(true);
		String mode = this.request.getParameter("mode");
		
		this.userLoggato= (Utente) session.getAttribute("UserLoggato");
		String usernameLoggato = this.userLoggato.getUsername();
		
		if (mode != null) {
			switch (mode) {
			case "GestioneUtentiAdmin":
				visualizzaListaUtenti();
				getServletContext().getRequestDispatcher("/admin/usersManagementAdmin.jsp").forward(this.request, this.response);
				break;
			case "GestioneUtentiNetworkManager":
				break;
			case "AggiungiProfiloAdmin":
//				Utente newUtente = new Utente(0, "", "", "");
//				this.request.setAttribute("newUtente", newUtente);
				getServletContext().getRequestDispatcher("/admin/insertUserAdmin.jsp").forward(this.request, this.response);
				break;
			case "CancellaProfiloAdmin":
				String username = this.request.getParameter("username");
				cancellaProfilo(username);
				visualizzaListaUtenti();
				getServletContext().getRequestDispatcher("/admin/usersManagementAdmin.jsp").forward(this.request, this.response);
				break;
			case "Register":
				int idUtente = Integer.parseInt(request.getAttribute("idUser").toString());
				String username2 = request.getAttribute("username").toString();
				String password = request.getAttribute("password").toString();
				String ruolo = request.getAttribute("ruolo").toString();
				Utente newUtente = new Utente(idUtente, ruolo, username2, password);
				aggiungiProfilo(newUtente);
				getServletContext().getRequestDispatcher("/admin/usersManagementAdmin.jsp").forward(this.request, this.response);
				break;
			case "ChangeUser":
				String username2User = this.request.getParameter("username").toString();
				String passwordUser = this.request.getParameter("password").toString();
				Utente newUtenteUser = new Utente("utente semplice", username2User, passwordUser);
				modificaProfilo(newUtenteUser,usernameLoggato);
				getServletContext().getRequestDispatcher("/index.jsp").forward(this.request, this.response);
				break;
			case "ModificaProfiloAdmin":
				
//			case "Register":
//				int idUtente = Integer.parseInt(request.getAttribute("idUser").toString());
//				String username2 = request.getAttribute("username").toString();
//				String password = request.getAttribute("password").toString();
//				String ruolo = request.getAttribute("ruolo").toString();
//				Utente newUtente = new Utente(idUtente, ruolo, username2, password);
//				aggiungiProfilo(newUtente);
//				getServletContext().getRequestDispatcher("/admin/usersManagementAdmin.jsp").forward(this.request, this.response);
//				break;
			case "back":
				back(session);
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

	private void visualizzaListaUtenti() {
		List<Utente> utentiList = this.utenteService.getAllUtenti();
		this.request.setAttribute("listaUtenti", utentiList);
	}
	
	private void aggiungiProfilo(Utente newUtente) {
		if (this.utenteService.insertUtente(newUtente)) {
			System.out.println("Nuovo utente Aggiunto correttamente");
		} else {
			System.out.println("Utente già esistente");
		}
	}
	
	private void modificaProfilo(Utente newUtenteUser,String usernameLoggato) {
		if (this.utenteService.setUtente(newUtenteUser,usernameLoggato)) {
			System.out.println("Utente Aggiornato correttamente");
		} else {
			System.out.println("Utente già esistente");
		}
	}

	
	private void cancellaProfilo(String username) {
		if (this.utenteService.deleteUtente(username)) {
			System.out.println("Utente \"" + username + "\" Cancellato correttamente");
		} else {
			System.out.println("Utente \"" + username + "\" non presente");
		}
	}

}
