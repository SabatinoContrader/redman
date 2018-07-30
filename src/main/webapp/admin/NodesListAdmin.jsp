<%@ page import="com.virtualpairprogrammers.model.Nodo" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Nodo> all_nodi = (List<Nodo>) request.getAttribute("listaNodi");%>
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
                       <%for (Nodo nodo : all_nodi) { %>
                    <tr>
                        <td>
                            <input type="checkbox" name="products" value="<%= nodo.getIdnodo()%>"/>
                        </td>
               
                        <td>
                        <p align = center>
                            <%= nodo.getIdnodo()%>
                        </td>             
               
                        <td>
                         <p align = center>
                            <%=  nodo.getInfonodo()%>  
                        </td>             

                        <td>
                         <p align = center>
                            <%=  nodo.getStatonodo()%>    
                        </td>             

                        
                        <td> 
                         <p align = center>                      
                            <%=  nodo.getGruppi_idgruppo()%>                 
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