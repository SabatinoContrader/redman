<%@ page import="com.virtualpairprogrammers.model.Nodo"%>
<%@ page import="java.util.*"%>

<html>
<head>
	<meta charset="ISO-8859-1">
	<%
		List<Nodo> ListaNodi = (List<Nodo>) session.getAttribute("listaNodi");
	%>
	
	<link rel="stylesheet" type="text/css" href="./css/tables.css">

</head>

<body>

	<div class="header">
		<a href="NodesServlet?mode=back" ><img alt="Home" src="./icon/home.png"></a>
		<a href="NodesServlet?mode=CreaNodoAdmin" ><img alt="Add node" src="./icon/add.png"></a>
		<h1>Gestione Nodi Amministratore</h1><br>
	</div>
	
	<form action="NodesServlet" method="post">
		<div class="tables">
			<table>
					
				<thead>
					<tr>
						<th style="width:10%">Id nodo</th>
						<th style="width:25%">Info nodo</th>
						<th style="width:15%">Responsabile nodo</th>
						<th style="width:10%">Stato nodo</th>
						<th style="width:10%">Id gruppo</th>	
						<th style="width:23%">Modifica responsabile nodo</th>
						<th style="width:7%">Elimina</th>	
					</tr>
				</thead>
			
				<tbody>
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
							<input style="width: 80%;" type="text" name="nodo_<%=nodi.getIdnodo()%>" 
							<%if(nodi.getResponsabileNodo()==null){
								out.print("value=\"\"");
							}else{
								out.print("value='"+nodi.getResponsabileNodo()+"'");
							}
							%>placeholder="Inserisci username responsabile" class="center">
						</td>
		
						<td>
							<a href="NodesServlet?mode=CancellaNodoAdmin&idNodo=<%=nodi.getIdnodo()%>"><img src="./icon/delete.png" alt="Delete"
							style="width: 35px; height: 35px;" class="center"></a>
						</td>
						
						
		
					</tr>
					
					<%
						}
					%>
				</tbody>
			
			</table>
		</div>
			
		<h3 align="center">
			<%if (request.getAttribute("error") != null) {
					if (request.getAttribute("error").toString().equalsIgnoreCase("constraintViolation")) {
						out.print("Impossibile eliminare nodo: task in esecuzione");
					} else if (request.getAttribute("error").toString().equalsIgnoreCase("false")) {
						out.print("Errore: impossibile eliminare nodo");
					}
				}%>		
		</h3><br>
				
			<button type="submit" value="AssegnaNodiAdmin" name="mode">Associa Nodi</button>
		
	</form>
	
</body>

</html>