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
                  <td>
                  </td>
                  </td>
                  </tr>
                    <tr>
                       <th></th>
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
                        <td>
                            <input type="checkbox" name="products" value="<%= utente.getIdutente()%>"/>
                        </td>
               
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
            
                        <td>             
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
                
                <form action = "RegisterServlet" method= "post">
				<h2>username: <input type = "text" id = "user" name ="username"></h2>
				<h2>password: <input type = "text" id = "pass" name ="password"></h2>
				<h2>ruolo: <input type = "text" id = "role" name ="ruolo"></h2>
				<button type = "submit" value = "Register" name = "pulsante">Registra Utente</button><br>
				</form>
</body>
</html>