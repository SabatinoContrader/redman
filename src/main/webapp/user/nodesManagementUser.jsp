<%@ page import="com.virtualpairprogrammers.model.Nodo" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Nodo> listaNodi = (List<Nodo>) request.getAttribute("statoNodiUser");%>

</head>
<body>
<h2 align="center">Gestione Nodi Utente Semplice</h2>

 <form action="NodesServlet" method="post">
                <table>
                    <tr>            
                        <th>
                            INFO_NODO
                        </th>
                         
                        <th>
                            STATO_NODO
                        </th>
                        <th>
                         </th>
                        <th>
                         </th>
               
                    </tr>
                       <%for (Nodo nodi : listaNodi) { %>
                    <tr>
                        <td>
                         <p align = center>
                            <%=  nodi.getInfonodo()%>  
                        </td>             

                        <td>
                         <p align = center>
                            <%=  nodi.getStatonodo()%>    
                        </td>             

                        
                        <td>             
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
</form>
</form>
 <form action="NodesServlet" method="post">
     <button type="submit" value="back" name="mode" >Indietro</button>
     </form>

</body>
</html>