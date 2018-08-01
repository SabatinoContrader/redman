<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.virtualpairprogrammers.model.Utente" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">--------MENU ADMIN--------</h1>
<%Utente utente = (Utente) request.getSession().getAttribute("UserLoggato"); %>
<h2 align="center">Benvenuto <%=utente.getUsername() %></h2>

<form action="UtentiServlet" method="post">
    <button type="submit" value="GestioneUtentiAdmin" name="mode">Gestione Utenti</button> 
</form>
<br>
<form action="NodesServlet" method="post">
    <button type="submit" value="GestioneNodiAdmin" name="mode">Gestione Nodi</button> 
 </form>
<br>
<form action="LogoutServlet" method="post">
    <button type="submit" value="ModificaProfiloPersonale" name="mode">Modifica Profilo Personale</button> 
 </form>
<br> 
<form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
</form>

</body>
</html>
