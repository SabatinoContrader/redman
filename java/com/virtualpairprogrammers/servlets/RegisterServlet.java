package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.NodoService;
import com.virtualpairprogrammers.services.UtenteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UtenteService utenteService;
    private HttpServletRequest request;
    private Utente userLoggato;
    
    public RegisterServlet() {
		this.utenteService = new UtenteService();
	}
    
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.request = request;
		HttpSession session = this.request.getSession(true);
		this.userLoggato= (Utente) session.getAttribute("UserLoggato");
		String usernameLoggato = this.userLoggato.getUsername();
        if (request != null) {
            String nomeUtente = request.getParameter("username").toString();
            String password = request.getParameter("password").toString();
            String ruolo = request.getParameter("ruolo").toString();
        	Utente utente = new Utente( ruolo, nomeUtente, password);

            if(ruolo.equalsIgnoreCase("amministratore")) {
            	 if (this.utenteService.setUtente(utente, usernameLoggato)) {
                     response.sendRedirect("index.jsp");
            	 } else {
                     response.sendRedirect("admin.jsp");
            	 }    
            } else if(ruolo.equalsIgnoreCase("utente semplice")) {
				if (this.utenteService.insertUtente(utente)) {
                    response.sendRedirect("index.jsp");
				} else {
                    response.sendRedirect("user.jsp");
				}                    
            }
            
           
        }

    }
}