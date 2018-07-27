package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginTraderServlet extends HttpServlet {

	private LoginService loginService;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginService = new LoginService();
		HttpSession session = request.getSession();
		session.setAttribute("utente", null);
		
		String nomeUtente = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String ruolo = loginService.login(nomeUtente, password);
		if (ruolo != null) {
			session.setAttribute("utente", nomeUtente);	
			if (ruolo.equalsIgnoreCase("amministratore")) {
				getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(request, response);
			} else if (ruolo.equalsIgnoreCase("responsabile di rete")) {
				getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(request, response);
			} else if (ruolo.equalsIgnoreCase("utente semplice")) {
				
				getServletContext().getRequestDispatcher("user/User.jsp").forward(request, response);
				
			}
		
		}
	}
}
