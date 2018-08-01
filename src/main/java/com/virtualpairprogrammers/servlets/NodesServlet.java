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
import java.util.Arrays;
import java.util.List;

public class NodesServlet extends HttpServlet {

    private NodoService nodoService;
    private UtenteService utenteService;
    private HttpServletRequest request;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String gestionenodo = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        nodoService =  new NodoService();
        switch (gestionenodo) {
         case "CreaNodoAdmin":
        	 Nodo nodo = (Nodo) request.getAttribute("NuovoNodo");
     		if (this.nodoService.insertNodo(nodo)) {
     			System.out.println("Nuovo nodo Aggiunto con successo\n");
     		} else {
     			System.out.println("Nodo gi� presente nel sistema");
     		}
             break;
         case "AssegnaNodiAdmin":
        	 List<String> ListaIdnodi; 
     		String idNodi= request.getAttribute("idNodi").toString();
     		String UsernameNodi= request.getAttribute("usernameResponsabileNodi").toString();
     		if(utenteService.getRuoloUtente(UsernameNodi).equals("responsabile di rete")) {
     			int idUtente=utenteService.getidUtente(UsernameNodi);
     			ListaIdnodi=Arrays.asList(idNodi.split(";"));
     			for(String idNodo:ListaIdnodi) {
     				nodoService.UtenteNodo(idUtente, Integer.valueOf(idNodo));
     			}
     			System.out.println("Nodi Associati con successo");	
     		}else {
     			System.out.println("L'utente "+UsernameNodi+" non � un responsabile di rete");
     		}
             break;
         case "CancellaNodiAdmin":
        	 break;
         case "VisualizzaListaNodiAdmin":
        	 List<Nodo> listanodiadmin = this.nodoService.getAllnodi();
             request.setAttribute("ListaNodi", listanodiadmin);
             getServletContext().getRequestDispatcher("/admin/NodesListAdmin.jsp").forward(request,response);
             break;
         case "VisualizzaNodiNetworkManager":
        	 String utente=((Utente) request.getAttribute("UserLoggato")).getUsername();	
     		 int Utente= utenteService.getidUtente(utente);
     		 List<Nodo> nodi = nodoService.getResponsabileNodi(Utente);
     		 request.setAttribute("listaNodiNetworkManager", nodi);
     		 getServletContext().getRequestDispatcher("/user/NodesManagementeNetworkManager.jsp").forward(request,response);
             break;
         case "AssociaNodiNetworkManager":
        	List<String> ListaIdnodiAss; 
     		String idNodiAss= request.getAttribute("idNodi").toString();
     		String UsernameNodiAss= request.getAttribute("usernameNodi").toString();
     		int UtenteAss=utenteService.getidUtente(UsernameNodiAss);
     		ListaIdnodiAss=Arrays.asList(idNodiAss.split(";"));
     		for(String idNodo:ListaIdnodiAss) {
     			nodoService.UtenteNodo(UtenteAss, Integer.valueOf(idNodo));
     		}
     		System.out.println("Nodi Associati con successo");				
             break;
         case "DisassociaNodiNetworkManager":
        	List<String> DisassociaNodi; 
     		String idNodiDiss= request.getAttribute("idNodi").toString();
     		DisassociaNodi= Arrays.asList(idNodiDiss.split(";"));
     		for(String idNodo:DisassociaNodi) {
     			nodoService.UtenteNullNodo(Integer.valueOf(idNodo));
     		}
     		System.out.println("Nodi Disassociati con successo");
         	 break;
         case "VisualizzaAssociazioniNodiNetworkManager":
         	 break;
         case "VisualizzaStatoNodiUser":
        	 Utente utentenodi = (Utente) request.getAttribute("UserLoggato");
     		 int idUtente = this.utenteService.getidUtente(utentenodi.getUsername());
        	 List<Nodo> listanodiuser = this.nodoService.getStatoNodi(idUtente);
     		 request.setAttribute("statoNodiUser", listanodiuser);
     		 getServletContext().getRequestDispatcher("/user/NodesListUser.jsp").forward(request,response);
        	 break;
         case "back":
        	 break; 
        }
    }
}
	