<%@ page import="com.virtualpairprogrammers.model.Utente" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Utente> all_utenti = (List<Utente>) request.getAttribute("listaUtenti");%>
</head>

<body>
        <form action="UtentiServlet" method="post">
                <table>
                <tr>
                  <td>
                     Utenti:
                  </td>
                  
                  </tr>
                    <tr>
                       
                        <th>
                            ID_UTENTE
                        </th>
               
                        <th>
                            USERNAME
                        </th>
                        <th>
                            RUOLO
                        </th>
                        <th>
                         </th>
                        <th>
                         </th>
               
                    </tr>
                       <%for (Utente utente : all_utenti) { %>
                    <tr>
                       <!-- <td>
                            <input type="checkbox" name="users" value="<%= utente.getIdutente()%>"/>
                        </td>-->
                                     
                        <td>
                        <p align = center>
                            <%= utente.getIdutente()%>
                        </td>
               
                        <td>
                        <p align = center>
                            <%=  utente.getUsername()%>
                        </td>
               
                        <td>
                        <p align = center>
                            <%=  utente.getRuolo()%>
                        </td>
            
            			<!--<td>
                        <p align = center>
             				<a href="UtentiServlet?mode=CancellaProfiloAdmin&username=<%= utente.getUsername()%>">Cancella Profilo</a>							
                        </td>-->
               			
                        <td>
                        <a href="UtentiServlet?mode=CancellaProfiloAdmin&username=<%= utente.getUsername()%>">
                        	<img src="./icon/delete_user.png" alt="Delete" style="width:40px;height:40px;">
                        	</a>           
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
           	<br>



		<form action="UtentiServlet" method="post">
			<button type="submit" value="add" name="mode">Aggiungi profilo</button>
			<button type="submit" value="back" name="mode">Indietro</button>
		</form></body>
		
		
</html>