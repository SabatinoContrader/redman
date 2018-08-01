package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HomeServlet extends HttpServlet {

	private LoginService loginService;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String mode = request.getParameter("mode"); 
        switch (mode) { 
        	case "GestioneUtentiNetworkManager": 
        		getServletContext().getRequestDispatcher("/networkManager/usersManagementNetworkManager.jsp").forward(request,response); 
		        break; 
		    case "GestioneNodiNetworkManager": 
		        getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request,response); 
		        break;
		    case "GestioneTaskNetworkManager": 
		        getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request,response); 
		        break;
		    case "ModificaProfiloPersonale": 
		        getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request,response); 
		        break;
		    case "indietro": 
		        getServletContext().getRequestDispatcher("/user/user.jsp").forward(request,response); 
		        break;
		    case "indietroNM": 
		        getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(request,response); 
		        break;
		}
	}
}
