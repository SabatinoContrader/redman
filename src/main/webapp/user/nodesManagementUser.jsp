<%@ page import="com.virtualpairprogrammers.model.Nodo" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/tables.css">
<title>Gestione Nodi Utente Semplice</title>
<% List<Nodo> listaNodi = (List<Nodo>) request.getAttribute("statoNodiUser");%>

</head>
<body>
	<div class="header">
		<a href="NodesServlet?mode=back" ><img alt="Home" src="./icon/home.png"></a>
		<h1>Gestione Nodi Utente Semplice</h1><br>
	</div>

 <form action="NodesServlet" method="post">
 	<div class ="tables">
		<table>
			<thead>
			    <tr>            
			        <th>Info nodo</th>		         
			        <th>Stato nodo</th>		
			        <th>Avviso per fault di nodo</th>		
			        
			    </tr>
			</thead>
			<tbody> 
				
				<%for (Nodo nodo : listaNodi) { %>
					<tr>			
			    		<td><p align = center><%=  nodo.getInfonodo()%></td>      	
						<td><p align = center><%=  nodo.getStatonodo()%></td> 
						<td align = center><a href="mailto:m.caponera@contrader.it?cc=marta.caponera@tiscali.it&subject=nodo%20<%=  nodo.getIdnodo()%>%20in%20fault&body=nodo%20in%20fault">Scrivi una MAIL</a></td> 
						
					</tr>
				<%}%>            
				
					
			</tbody> 
		</table>
	</div>
</form>



</body>
</html>