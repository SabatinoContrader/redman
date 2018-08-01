<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "com.virtualpairprogrammers.model.Utente" %>
<!DOCTYPE html>
<html> 
<head> 
<title>Responsabile</title> 
</head> 
<body> 
     <h1 align="center">MENU <br>*** RESPONSABILE *** </h1><br>
     <% Utente utente = (Utente) request.getSession().getAttribute("UserLoggato"); %>
     <h2 align = "center" > Benvenuto <%=utente.getUsername() %> </h2>
     
     
     <form action="HomeServlet" method="post"> 
     <button type="submit" value="GestioneUtentiNetworkManager" name="mode">Gestione Utenti</button> 
     </form> 
 	 <br>
     <form action="HomeServlet" method="post"> 
     <button type="submit" value="GestioneNodiNetworkManager" name="mode">Gestione Nodi</button> 
     </form> 
 	 <br>
     <form action="TasksServlet" method="post"> 
     <button type="submit" value="GestioneTaskNetworkManager" name="mode">Gestione Task</button>
     </form>
     <br>      
     <form action="HomeServlet" method="post"> 
     <button type="submit" value="ModificaProfiloPersonale" name="mode">Modifica Profilo Personale</button> 
     </form> 
     <br>
	 <form action="LogoutServlet" method="post"> 
     <button type="submit" value="Logout" name="Logout">Logout</button> 
     </form> 
</body> 
</html> 
