<%@ page import="com.virtualpairprogrammers.model.Task" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Task> listaTasks = (List<Task>) request.getAttribute("listaTasks");%>
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
                       <%for (Task tasks : listaTasks) { %>
                    <tr>
                        <td>
                            <input type="checkbox" name="products" value="<%= tasks.getIdtask()%>"/>
                        </td>
               
                        <td>
                        <p align = center>
                            <%= tasks.getIdtask()%>
                        </td>
               
                        <td>
                        <p align = center>
                            <%=  tasks.getIdnodo()%>
                        </td>
               
                        <td>
                        <p align = center>
                            <%=  tasks.getInfotask()%>
                        </td>
                        
                             <td>
                        <p align = center>
                            <%=  tasks.getStatotask()%>
                        </td>
            
                        <td>             
                        </td>
                        <td>
                        <p align = center>
             				<a href="TasksServlet?mode=SegnalaFaultTask">Segnala Fault</a>							
                        </td>
                         <td>
                           <a href="TasksServlet?mode=SospendiTask">Sospendi</a>
                        </td>  
                        <td>
                           <a href="TasksServlet?mode=Associa=<%=  tasks.getIdnodo()%>"> Associa</a>
                        </td>
                              
                         <td>
                        <td>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
                </form>
</form>
 <form action="HomeServlet" method="post">
     <input type="submit" value="indietroNM" name="mode" >
     </form>

</body>
</html>