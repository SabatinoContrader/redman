package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.UtenteService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UtenteService utenteService;

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        utenteService = new UtenteService();
        if (request != null) {
            String nomeUtente = request.getParameter("username").toString();
            String password = request.getParameter("password").toString();
            String ruolo = request.getParameter("ruolo").toString();
            if (utenteService.insertUtente(new Utente(nomeUtente, password , ruolo)))
                response.sendRedirect("index.jsp");
            else
                response.sendRedirect("admin.jsp");
        }

    }
}
