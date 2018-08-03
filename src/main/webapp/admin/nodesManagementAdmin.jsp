<%@ page import="com.virtualpairprogrammers.model.Nodo"%>
<%@ page import="java.util.*"%>
<%@ page import="com.virtualpairprogrammers.model.Utente"%>

<html>
<head>
<meta charset="ISO-8859-1">
<%
	List<Nodo> ListaNodi = (List<Nodo>) request.getAttribute("listaNodi");
%>
<style type="text/css">
	table{
		width:100%;
	} 
</style>

</head>

<body>
	<h2 align="center">Gestione Nodi Amministratore</h2>

	<form action="NodesServlet" method="post">
		<table>
			<tr>
				<td></td>
				<td></td>
				</td>
			</tr>
			<tr>
				<th>Id nodo</th>

				<th>Info nodo</th>
				
				<th>Responsabile nodo</th>

				<th>Stato nodo</th>

				<th>Id gruppo</th>
				
				<th align="left">Modifica responsabile nodo</th>
				<th></th>

			</tr>
			<%
				for (Nodo nodi : ListaNodi) {
			%>
			<tr>
				<td>
					<p align=center><%=nodi.getIdnodo()%>
				</td>

				<td>
					<p align=center><%=nodi.getInfonodo()%>
				</td>
				
				<td>
					<p align=center><%=nodi.getResponsabileNodo()%>
				</td>

				<td>
					<p align=center><%=nodi.getStatonodo()%>
				</td>


				<td>
					<p align=center><%=nodi.getGruppi_idgruppo()%>
				</td>
				
				<td>
					<input type="text" name="nodo_<%=nodi.getIdnodo()%>" 
					<%if(nodi.getResponsabileNodo()==null){
						out.print("value=\"\"");
					}else{
						out.print("value='"+nodi.getResponsabileNodo()+"'");
					}
					%>placeholder="Inserisci username responsabile" size="30">
				</td>

				<td>
						<a href="NodesServlet?mode=CancellaNodoAdmin&idNodo=<%=nodi.getIdnodo()%>"><img src="./icon/delete.png" alt="Delete"
						style="width: 40px; height: 40px;" align="left"></a>
				</td>
				
				<td></td>

			</tr>
			<%
				}
			%>
		</table>
		<h3 align="center">
		<%
			if (request.getAttribute("error") != null) {
				if (request.getAttribute("error").toString().equalsIgnoreCase("constraintViolation")) {
					out.print("Impossibile eliminare nodo: task in esecuzione");
				} else if (request.getAttribute("error").toString().equalsIgnoreCase("false")) {
					out.print("Errore: impossibile eliminare nodo");
				}
			}
		%>
		</h3>
		<br>
		<button type="submit" value="AssegnaNodiAdmin" name="mode">Associa Nodi</button>
		<button type="submit" value="CreaNodoAdmin" name="mode">Crea Nuovo Nodo</button>
		<button type="submit" value="back" name="mode">Indietro</button>
	</form>
	
</body>
</html>