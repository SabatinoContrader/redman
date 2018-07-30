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
      <a href="gestioneNodiUtente.jsp">Gestione nodi</a>
     
</li>

<li>Modifica profilo personale</li>
<%-- 
<li><form action="RegisterServlet" method="post">
     <input type="submit" value="" name="">
     </form></li>
<li>
--%>
<li>
<form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form></li>
</ol>

</body>
</html>