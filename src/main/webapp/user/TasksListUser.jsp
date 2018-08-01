<%@ page import="com.virtualpairprogrammers.model.Task" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Task> all_tasks = (List<Task>) request.getAttribute("listaTasks");%>

</head>
<body>

 <form action="TasksServlet" method="post">
                <table>
                <tr>
                  <td>
                     Tasks:
                  </td>
                  <td>
                  </td>
                  </td>
                  </tr>
                    <tr>
                       <th></th>
                        <th>
                            ID_TASK
                        </th>
                         
                        <th>
                            ID_NODO
                        </th>              
                        <th>
                            INFO_TASK
                        </th>
                         
                        <th>
                            STATO_TASK
                        </th>
                        <th>
                         </th>
                        <th>
                         </th>
               
                    </tr>
                       <%for (Task task : all_tasks) { %>
                    <tr>
                        <td>
                            <input type="checkbox" name="products" value="<%= task.getIdtask()%>"/>
                        </td>
                 
                        <td>
                         <p align = center>
                            <%=  task.getIdnodo()%>  
                        </td>             

                        <td>
                         <p align = center>
                            <%=  task.getInfotask()%>    
                        </td>             
                        <td>
                         <p align = center>
                            <%=  task.getStatotask()%>    
                        </td> 
                        <td>
                           <a href="TasksServlet?richiesta=SospendiTask=<%=  task.toString()%>">Sospendi</a>
                        </td>  
                        <td>
                           <a href="TasksServlet?richiesta=Associa=<%=  task.toString()%>"> Associa</a>
                        </td>         
                         <td>
                           <a href="NodesServlet?richiesta=AggiornaInfo=<%=  task.toString()%>"> Aggiorna</a>
                        </td>
                        <td>             
                        </td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
</form>
 <form action="HomeServlet" method="post">
     <input type="submit" value="indietro" name="mode" >
     </form>

</body>
</html>