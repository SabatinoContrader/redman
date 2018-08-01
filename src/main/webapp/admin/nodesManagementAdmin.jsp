<%@ page import="com.virtualpairprogrammers.model.Nodo" %>
<%@ page import="java.util.*" %>

<html>
<head>
<meta charset="ISO-8859-1">
<% List<Nodo> ListaNodi = (List<Nodo>) request.getAttribute("listaNodi");%>
</head>

<body>
        <form action="NodesServlet" method="post">
                <table>
                <tr>
                  <td>
                     Nodi:
                  </td>
                  <td>
                  </td>
                  </td>
                  </tr>
                    <tr>
                       <th></th>
                        <th>
                            ID_NODO
                        </th>
               
                        <th>
                            INFO_NODO
                        </th>
                         
                        <th>
                            STATO_NODO
                        </th>
                         
                        <th>
                            GRUPPI_IDGRUPPO
                        </th>
                        <th>
                         </th>
                        <th>
                         </th>
               
                    </tr>
                       <%for (Nodo nodi : ListaNodi) { %>
                    <tr>
                        <td>
                            <input type="checkbox" name="products" value="<%= nodi.getIdnodo()%>"/>
                        </td>
               
                        <td>
                        <p align = center>
                            <%= nodi.getIdnodo()%>
                        </td>             
               
                        <td>
                        <p align = center>
                            <%=  nodi.getInfonodo()%>  
                        </td>             

                        <td>
                        <p align = center>
                            <%=  nodi.getStatonodo()%>    
                        </td>             

                        
                        <td> 
                        <p align = center>                      
                            <%=  nodi.getGruppi_idgruppo()%>                 
                        </td>
                       	
                       	<td>
                        <p align = center>
             				<a href="NodesServlet?mode=CancellaNodoAdmin&idNodo=<%= nodi.getIdnodo()%>">Cancella Nodo</a>							
                        </td>
               			
                        <td>             
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
                </form>
<form action="NodesServlet" method="post">
    <button type="submit" value="CreaNodoAdmin" name="mode">Crea Nuovo Nodo</button> 
</form>            
<form action="NodesServlet" method="post">
    <button type="submit" value="back" name="mode">Indietro</button> 
</form>            
<h3 align="center">
	<%if(request.getAttribute("error") != null) {
		if(request.getAttribute("error").toString().equalsIgnoreCase("constraintViolation")) {
			out.print("Impossibile eliminare nodo: task in esecuzione");
		} else if(request.getAttribute("error").toString().equalsIgnoreCase("false")) {
			out.print("Errore: impossibile eliminare nodo"); 
		}
	  } %>
</h3>
                
</body>
</html>