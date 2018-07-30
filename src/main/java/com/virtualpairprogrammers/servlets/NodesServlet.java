package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.model.Nodo;
import com.virtualpairprogrammers.services.NodoService;

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
	private HttpServletRequest request;
	
	public NodesServlet() {
		nodoService= new NodoService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.service(req, resp);
		
		this.request=request;
		visualizzaListaNodi();
		getServletContext().getRequestDispatcher("/admin/NodesListAdmin.jsp").forward(this.request, response);

	}

	private void visualizzaListaNodi() {
		List<Nodo> nodi = nodoService.getAllnodi();
		this.request.setAttribute("listaNodi", nodi);
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

