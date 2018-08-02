<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.virtualpairprogrammers.model.Utente"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1 align="center">--------MENU-UTENTE-------</h1>
<br>
<% Utente utente = (Utente) request.getSession().getAttribute("UserLoggato"); %>
	<h2 align="center">	Benvenuto <%=utente.getUsername()%> </h2>
<ol>

<li>
	<form action="NodesServlet" method="post">
		<button type="submit" value="VisualizzaStatoNodiUser" name="mode">Gestione Nodi</button>
	</form>
</li>

<li>

<form action="ModifyProfileServlet" method="post">
		<button type="submit" value="ModificaProfiloPersonale" name="mode">Modifica
			Profilo Personale</button>
</form>

<li><form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
</li>
</ol>

</body>
</html>
