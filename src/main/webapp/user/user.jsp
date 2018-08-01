

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h1>--------MENU-UTENTE-------</h1>
<br>
<ol>

<li>
     <form action="NodesServlet" method="post">
     <input type="submit" value="Gestione nodi" name="mode" >
     </form>
</li>

 <li>
 <form action="NodesServlet" method="post">
     <input type="submit" value="Visualizza segnalazioni" name="mode" >
     </form>
</li>

<li>
<form action = "UtentiServlet" method= "post">
				<h2>username: <input type = "text" id = "user" name ="username"></h2>
				<h2>password: <input type = "text" id = "pass" name ="password"></h2>
				<input type="text" value="ChangeUser" name="mode" hidden>
				<button type = "submit">Modifica profilo</button><br>
				</form>


<%--<form action="RegisterServlet" method="post">
     <input type="submit" value="Modifica profilo personale" name="mode">
     </form> --%>
</li>

<li><form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>
</li>
</ol>

</body>
</html>
