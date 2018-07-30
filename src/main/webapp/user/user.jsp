<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a>******UTENTE*******</a>
<h1>--------MENU--------</h1>
<br>
<ol>

<li>
     <form action="NodesServlet" method="post">
     <input type="submit" value="Gestione nodi" name="mode" >
     </form>
</li>

 
<li><form action="RegisterServlet" method="post">
     <input type="submit" value="Modifica profilo personale" name="mode">
     </form></li>
<li>

<li>
<form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form></li>
</ol>

</body>
</html>