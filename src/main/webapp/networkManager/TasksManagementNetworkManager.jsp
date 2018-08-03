<%@page import="com.virtualpairprogrammers.model.Nodo"%>
<%@page import="java.awt.Window.Type"%>
<%@ page import="com.virtualpairprogrammers.model.Task" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Task> listaTasks = (List<Task>) request.getAttribute("listaTasks");%>
<%! ArrayList<Nodo> listaNodi;  %>
<% String nodoList;  %>

<style type="text/css">
	table{
		width:100%;
	} 
</style>

</head>

<body>

<% listaNodi = new ArrayList<Nodo>();
listaNodi.add(new Nodo(1,"nodo1","ON",2));
listaNodi.add(new Nodo(2,"nodo1","ON",2));
listaNodi.add(new Nodo(3,"nodo1","ON",2));
listaNodi.add(new Nodo(4,"nodo1","ON",2));
listaNodi.add(new Nodo(5,"nodo1","ON",2));
%>

<h2 align="center">Gestione Tasks Network Manager</h2>

        <form action="TasksServlet" method="post">
                <table>
                <tr>
                </tr>
                    <tr>
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
                        <p align = center>
                            <%= tasks.getIdtask()%>
                        </td>
               
                        <td>
                        <p align = center>
                            <%if(tasks.getIdnodo()==0){
                            	out.print("/");
                            }else{
                            	out.print(tasks.getIdnodo());
                            }%>
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
                              
<%--                          <td>
                         <input type="number" name="task_<%=tasks.getIdtask()%>" <%
	                         if(tasks.getIdnodo()==0){
								out.print("value=\"\"");
							 }else{
								out.print("value='"+tasks.getIdnodo()+"'");
							}%> placeholder="Inserisci idnoodo da associare" size="30">
                        </td> --%>
                        
                        <td>
                        <select name="task_<%=tasks.getIdtask()%>">
	                        <%for(Nodo nodo:listaNodi){%>
	                        	<option value="<%=nodo.getIdnodo()%>"><%=nodo.getIdnodo()%></option>
	                        <%}%>
	                        	<option value="/">/</option>
						</select>
                        </td>
               
                    </tr>
                    <% }%>
                </table>
                
                  <input type="submit" value="Indietro" name="mode" >
                  <input type="submit" value="AssociaTasks" name="mode" >
                
                </form>
                
                
        <script>
        
        function getSelectValue(){
        	nodoList=document.getElementById("list").value;
            //console.log(selectedValue);
        }
        //getSelectValue();

    	</script>
	
</body>
</html>