package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginTraderServlet extends HttpServlet {

	private LoginService loginService;
	private HttpServletRequest request;
	private Utente userLoggato;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.loginService = new LoginService();
		HttpSession session = request.getSession();
		this.request = request;
		if(this.request==null) {
			getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
		}else if(checkUser(session)) {
			switch(this.userLoggato.getRuolo()) {
			case"amministratore":
				getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(request, response);
				break;
			case"responsabile di rete":
				getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(this.request, response);
				break;
			case"utente semplice":
				getServletContext().getRequestDispatcher("/user/user.jsp").forward(request, response);
				break;
			}
		}else {
			getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	private boolean checkUser(HttpSession session) {
		String nomeUtente = this.request.getParameter("username");
		String password = this.request.getParameter("password");
		String ruolo = loginService.login(nomeUtente, password);
		if (ruolo != null) {
			this.userLoggato = new Utente(ruolo, nomeUtente, password);
			session.setAttribute("UserLoggato", this.userLoggato);
			return true;
		} else {
			return false;
		}
	}

}
