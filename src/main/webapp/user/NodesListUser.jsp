<%@ page import="com.virtualpairprogrammers.model.Nodo" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Nodo> listaNodi = (List<Nodo>) request.getAttribute("listaNodi");%>

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
                            <input type="checkbox" name="products" value="<%= nodi.getIdnodo()%>"/>
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
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
</form>

</body>
</html>