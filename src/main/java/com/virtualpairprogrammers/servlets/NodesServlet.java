package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Nodo;
import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.services.NodoService;
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

public class NodesServlet extends HttpServlet {
	
	private NodoService nodoService;
	private UtenteService utenteService;
	private HttpServletRequest request;
	private Utente utente;
	
	public NodesServlet() {
		this.nodoService= new NodoService();
		this.utenteService = new UtenteService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.service(req, resp);
		this.request = request;
		HttpSession session = this.request.getSession(true);
		this.utente= (Utente) session.getAttribute("UserLoggato");
		
		if (this.utente.getRuolo().equalsIgnoreCase("amministratore")) {
			visualizzaListaNodi();
			getServletContext().getRequestDispatcher("/admin/NodesListAdmin.jsp").forward(this.request, response);
		} else if(this.utente.getRuolo().equalsIgnoreCase("utente semplice")) {
			visualizzaListaNodi();
			getServletContext().getRequestDispatcher("/user/NodesListUser.jsp").forward(this.request, response);
		}
		
	}

	private void visualizzaListaNodi() {
		int idUtente = this.utenteService.getidUtente(this.utente.getUsername());
		System.out.println(idUtente);
		if(this.utente.getRuolo().equalsIgnoreCase("amministratore")) {
			List<Nodo> nodi = this.nodoService.getAllnodi();
			this.request.setAttribute("listaNodi", nodi);
		}else if(this.utente.getRuolo().equalsIgnoreCase("utente semplice")) {
			List<Nodo> nodi = this.nodoService.getStatoNodi(idUtente);
			this.request.setAttribute("listaNodi", nodi);
		}
		
	}
		
		/* switch (gestionenodo) {
         case "CreaNodoAdmin":
             break;
         case "AssegnaNodiAdmin":
             break;
         case "CancellaNodiAdmin":
        	 break;
         case "VisualizzaListaNodiAdmin":
        	 List<Nodo> nodi = this.nodoService.getAllnodi();
             request.setAttribute("ListaNodi", nodi);
             getServletContext().getRequestDispatcher("/NodesListAdmin.jsp").forward(request,response);
             break;
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
        	 break; */
	}

