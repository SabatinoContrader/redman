<%@ page import="com.virtualpairprogrammers.model.Nodo" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<form action="NodesServlet" method="post">
    <input type="submit" value="SearchCategory" name="richiesta"> 
</form>
<% List<Nodo> ListaNodi = (List<Nodo>) request.getAttribute("ListaNodi");%>
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
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
                </form>
</body>
</html>