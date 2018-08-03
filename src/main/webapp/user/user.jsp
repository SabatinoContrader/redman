<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.virtualpairprogrammers.model.Utente"%>

<!DOCTYPE html>
<html>
<style>
img {
    display: block;
    margin-left: auto;
    margin-right: auto;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1 align="center">--------MENU-UTENTE-------</h1>
<img src="./icon/programmer.png" alt="Administrator icon "	style="width: 64px; height: 64px;">
<% Utente utente = (Utente) request.getSession().getAttribute("UserLoggato"); %>
	<h2 align="center">	Benvenuto <%=utente.getUsername()%> </h2>
<ol>
	<form action="NodesServlet" method="post">
		<button type="submit" value="VisualizzaStatoNodiUser" name="mode">Gestione Nodi</button>
	</form>
<br>
	<form action="ModifyProfileServlet" method="post">
		<button type="submit" value="ModificaProfiloPersonale" name="mode">Modifica	Profilo Personale</button>
	</form>
<br>
	<form action="LogoutServlet" method="post">
    	<input type="submit" value="Logout" name="Logout">
    </form>
</ol>

</body>
</html>
