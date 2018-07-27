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
        <form action="UtenteServlet" method="post">
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
                            <%= utente.getIdutente()%>
                        </td>
               
                        <td>
                            <%=  utente.getUsername()%>
                        </td>
               
                        <td>
                            <%=  utente.getRuolo()%>
                        </td>
            
                        <td>             
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
</body>
</html>