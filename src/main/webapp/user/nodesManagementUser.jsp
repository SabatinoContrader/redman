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
			    </tr>
			</thead>
			<tbody> 
				
				<%for (Nodo nodi : listaNodi) { %>
					<tr>			
			    		<td><p align = center><%=  nodi.getInfonodo()%></td>      	
						<td><p align = center><%=  nodi.getStatonodo()%></td> 
					</tr>
				<%}%>            
				
					
			</tbody> 
		</table>
	</div>
</form>



</body>
</html>