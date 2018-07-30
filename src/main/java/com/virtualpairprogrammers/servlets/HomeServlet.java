package com.virtualpairprogrammers.servlets;

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
		String mode = request.getParameter("mode"); 
        HttpSession session = request.getSession(true); 
        switch (mode) { 
        	case "GestioneUtentiNetworkManager": 
        		getServletContext().getRequestDispatcher("/networkManager/usersManagementNetworkManager.jsp").forward(request,response); 
		        break; 
		    case "GestioneNodiNetworkManager": 
		    	int prodottoModifica = Integer.parseInt(request.getParameter("id")); 
        		//session.setAttribute("prodotto", prodotto); 
		        getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request,response); 
		        //response.sendRedirect("insertProdotto.jsp"); 
		        break;
		    case "GestioneTaskNetworkManager": 
		    	//session.setAttribute("prodotto", prodotto); 
		        getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request,response); 
		        //response.sendRedirect("insertProdotto.jsp"); 
		        break;
		    case "ModificaProfiloPersonale": 
		    	//session.setAttribute("prodotto", prodotto); 
		        getServletContext().getRequestDispatcher("/insertProdotto.jsp").forward(request,response); 
		        //response.sendRedirect("insertProdotto.jsp"); 
		        break;
		
		}
	}
}
