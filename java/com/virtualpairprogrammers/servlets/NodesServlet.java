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
import java.util.HashMap;
import java.util.List;

public class NodesServlet extends HttpServlet {

    private NodoService nodoService;
    private UtenteService utenteService;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Utente userLoggato;
    private List<Nodo> nodeslist;
    
    public NodesServlet() {
		this.nodoService= new NodoService();
		this.utenteService = new UtenteService();
	}

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	this.request = request;
		this.response = response;
		HttpSession session = this.request.getSession(true);
		String mode = this.request.getParameter("mode");
		this.userLoggato= (Utente) session.getAttribute("UserLoggato");

		if (mode != null) {
			switch (mode) {         	
				case "CreaNodoAdmin":
					getServletContext().getRequestDispatcher("/admin/insertNodoAdmin.jsp").forward(this.request, this.response);
					break;
				case "InsertNodoAdmin":
					insertNodoAdmin();
					visualizzaListaNodi();
					getServletContext().getRequestDispatcher("/admin/nodesManagementAdmin.jsp").forward(this.request, this.response);
					break;
				case "CancellaNodoAdmin":
					cancellaNodoAdmin();
					visualizzaListaNodi();
					getServletContext().getRequestDispatcher("/admin/nodesManagementAdmin.jsp").forward(this.request, response);
					break;
				case "GestioneNodiAdmin"://OK
					visualizzaListaNodi();
					getServletContext().getRequestDispatcher("/admin/nodesManagementAdmin.jsp").forward(this.request, this.response);
					break;
				case "VisualizzaNodiNetworkManager":
					String utente=((Utente) request.getAttribute("UserLoggato")).getUsername();	
					int Utente= utenteService.getidUtente(utente);
					List<Nodo> nodi = nodoService.getResponsabileNodi(Utente);
					request.setAttribute("listaNodiNetworkManager", nodi);
					getServletContext().getRequestDispatcher("/user/NodesManagementeNetworkManager.jsp").forward(request,response);
					break;
//         		case "AssociaNodiNetworkManager":
//        			List<String> ListaIdnodiAss; 
//     				String idNodiAss= request.getAttribute("idNodi").toString();
//     				String UsernameNodiAss= request.getAttribute("usernameNodi").toString();
//     				int UtenteAss=utenteService.getidUtente(UsernameNodiAss);
//     				ListaIdnodiAss=Arrays.asList(idNodiAss.split(";"));
//     				for(String idNodo:ListaIdnodiAss) {
//     					nodoService.UtenteNodo(UtenteAss, Integer.valueOf(idNodo));
//     				}
//     				System.out.println("Nodi Associati con successo");				
//             		break;
//         		case "DisassociaNodiNetworkManager":
//        			List<String> DisassociaNodi; 
//     				String idNodiDiss= request.getAttribute("idNodi").toString();
//     				DisassociaNodi= Arrays.asList(idNodiDiss.split(";"));
//     				for(String idNodo:DisassociaNodi) {
//     					nodoService.UtenteNullNodo(Integer.valueOf(idNodo));
//     				}
//     				System.out.println("Nodi Disassociati con successo");
//         	 		break;
				case "VisualizzaAssociazioniNodiNetworkManager":
					break;
				case "AssegnaNodiAdmin":
					AssegnaNodiAdmin();
					getServletContext().getRequestDispatcher("/admin/nodesManagementAdmin.jsp").forward(this.request, this.response);
					break;
				case "VisualizzaStatoNodiUser":
					visualizzaStatoNodiUser();
					getServletContext().getRequestDispatcher("/user/nodesManagementUser.jsp").forward(this.request,this.response);
					break;
				case "back":
					back(session);
					break; 
				}
			}
		}
    
    private void visualizzaStatoNodiUser() {
    	int idUtente = this.utenteService.getidUtente(this.userLoggato.getUsername());
		System.out.println(idUtente);
    	List<Nodo> listanodiuser = this.nodoService.getStatoNodi(idUtente);
		this.request.setAttribute("statoNodiUser", listanodiuser);
    }
    
    private void visualizzaListaNodi() {
		nodeslist = this.nodoService.getAllnodi();
		this.request.setAttribute("listaNodi", nodeslist);
	}
    
    private void aggiungiProfilo(Utente newUtente) {
		if (this.utenteService.insertUtente(newUtente)) {
			System.out.println("Nuovo utente Aggiunto correttamente");
		} else {
			System.out.println("Utente già esistente");
		}
	}
	
	private void cancellaNodoAdmin() {
		int idNodo = Integer.parseInt(this.request.getParameter("idNodo").toString());
		String string = this.nodoService.deleteNodo(idNodo);
		if (string.equalsIgnoreCase("constraintViolation")) {
			this.request.setAttribute("error", "constraintViolation");
		} else if (string.equalsIgnoreCase("false")) {
			this.request.setAttribute("error", "false");
		}
	}
	
	private void AssegnaNodiAdmin() {
		for(Nodo nodo:nodeslist) {
			String parameter="nodo_"+nodo.getIdnodo();
			String usernameResponsabile = (String) this.request.getParameter(parameter);
			if(usernameResponsabile.equals("")) {
				nodoService.UtenteNodo(-1, nodo.getIdnodo());
			}else {
				int idUtente=utenteService.getidUtente(usernameResponsabile);
				nodoService.UtenteNodo(idUtente, nodo.getIdnodo());
			}
			
		}
		visualizzaListaNodi();
	}
	
	private void back(HttpSession session) throws ServletException, IOException {
		Utente userLoggato = (Utente) session.getAttribute("UserLoggato");
		if (userLoggato.getRuolo().equalsIgnoreCase("amministratore")) {
			getServletContext().getRequestDispatcher("/admin/admin.jsp").forward(this.request, this.response);;
		} else if (userLoggato.getRuolo().equalsIgnoreCase("responsabile di rete")) {
			getServletContext().getRequestDispatcher("/networkManager/networkManager.jsp").forward(this.request, this.response);;
		} else if (userLoggato.getRuolo().equalsIgnoreCase("utente semplice")) {		
			getServletContext().getRequestDispatcher("/user/user.jsp").forward(this.request, this.response);;
		}
	}
	
	private void insertNodoAdmin() {
		int idNodoIns = Integer.parseInt(this.request.getParameter("idNodo").toString());
		String infoNodo = this.request.getParameter("infonodo");
		int gruppo = Integer.parseInt(this.request.getParameter("gruppi_idgruppo").toString());
		this.nodoService.insertNodo(new Nodo(idNodoIns, infoNodo, "OFF", gruppo));
	}

}
	