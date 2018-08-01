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

public class DeleteNodesServlet extends HttpServlet {
	
	private NodoService nodoService;
	private UtenteService utenteService;
	private HttpServletRequest request;
	private Utente utente;
	
	public DeleteNodesServlet() {
		this.nodoService= new NodoService();
		this.utenteService = new UtenteService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.service(req, resp);
		this.request = request;
		
		
		
	}

}
		
		

