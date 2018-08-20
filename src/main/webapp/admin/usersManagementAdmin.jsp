<%@ page import="com.virtualpairprogrammers.model.Utente"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<% List<Utente> all_utenti = (List<Utente>) session.getAttribute("listaUtenti");%>
	<link rel="stylesheet" type="text/css" href="./css/tables.css">
</head>

<body>
	<div class="header">
		<a href="UtentiServlet?mode=back" ><img alt="Home" src="./icon/home.png"></a>
		<a href="UtentiServlet?mode=CreaUtenteAdmin" ><img alt="Add User" src="./icon/add_user.png"></a>
		<h1>Gestione Utenti Amministratore</h1><br>
	</div>

	<form action="UtentiServlet" method="post">
		<div class="tables">
			<table>
			<thead>
				<tr>
					<th>Id Utente</th>
					<th>Username</th>
					<th>Ruolo</th>
					
	
				</tr>
				</thead>
				<tbody>
				<%for (Utente utente : all_utenti) { %>
				<tr>
					<td>
						<p align=center><%= utente.getIdutente()%>
					</td>
	
					<td>
						<p align=center><%=  utente.getUsername()%>
					</td>
	
					<td>
						<p align=center><%=  utente.getRuolo()%>
					</td>
		
					
					
				</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
	
		</form>

</body>


</html>