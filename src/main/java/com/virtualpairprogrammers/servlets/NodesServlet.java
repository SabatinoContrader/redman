package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Nodo;
import com.virtualpairprogrammers.services.LoginService;
import com.virtualpairprogrammers.services.NodoService;
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

public class NodesServlet {
	
	private NodoService nodoService;
	private UtenteService utenteService;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gestionenodo = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        nodoService =  new NodoService();
		
		 switch (gestionenodo) {
         case "CreaNodoAdmin":
             break;
         case "AssegnaNodiAdmin":
             break;
         case "CancellaNodiAdmin":
        	 break;
         case "VisualizzaListaNodiAdmin":
             break;
         case "VisualizzaNodiNetworkManager":
            break;
         case "VisualizzaInfoNodiNetworkManager":
             break;
         case "AssociaNodiNetworkManager":
             break;
         case "DisassociaNodiNetworkManager":
         	 break;
         case "VisualizzaAssociazioniNodiNetworkManager":
         	 break;
         case "VisualizzaStatoNodiUser":
        	 break;
         case "back":
        	 break;
		 }

	}

}

