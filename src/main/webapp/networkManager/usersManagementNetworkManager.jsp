<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head> 
	 
</head> 
<body> 
    <h1 align="center">MENU <br>*** RESPONSABILE *** <br>
    <%= request.getSession().getAttribute("UserLoggato")%></h1> <br>
    <h2 align="center">Gestione Utenti</h2> <br>
              
    <form action="UtentiServlet" method="post"> 
    <button type="submit" value="GestioneUtentiNetworkManager" name="mode">Visualizza utenti associati ai tuoi nodi</button> 
    </form> 
 	<br>
    <form action="UtentiServlet" method="post">
    <button type="submit" value="back" name="modeUtenti">Indietro</button> 
    </form> 
 	</body>  
</html> 
