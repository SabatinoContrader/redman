<%@page import="com.virtualpairprogrammers.model.Nodo"%>
<%@page import="java.awt.Window.Type"%>
<%@ page import="com.virtualpairprogrammers.model.Task" %>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/tables.css">
	<title>Gestione Task Network Manager</title>
	<% List<Task> listaTasks = (List<Task>) request.getAttribute("listaTasks");%>
	<% List<Nodo> listaNodi= (List<Nodo>) request.getAttribute("listaNodiNetworkManager");%>
	

</head>

<body>
	<div class="header">
		<a href="TasksServlet?mode=back" ><img alt="Home" src="./icon/home.png"></a>
		<h1>Gestione Tasks Network Manager</h1><br>
	</div>

	<form action="TasksServlet" method="post">
		<div class="tables">
			<table>
			<thead>
				<tr>
					<th>
					    Id task
					</th>
					
					<th>
					    Id nodo
					</th>
					
					<th>
					    Info task
					</th>
					
					<th>
						Stato task
					</th>
					<th>
					</th>
					<th>
	
					</th>
					<th>
					Assegna task
					</th>
				</tr>
			</thead>
			<tbody>
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
						<p align = center><%=  tasks.getStatotask()%>
					</td>
					
			     
					<td>
				       <p align = center><a href="mailto:martarella.caponera@gmail.com?cc=marta.caponera@tiscali.it&subject=task%20in%20fault&body=task%20<%=  tasks.getIdtask()%>%20associato%20al%20nodo%20<%=  tasks.getIdnodo()%>%20in%20fault">Segnala Fault con Mail</a>							
					</td>
			       
					<td align = center>
					    <label class="switch">
                            <input type="checkbox">
                            <span class="slider round">sospendi</span>
                        </label>
						<%-- <a href="TasksServlet?mode=SospendiTask">Sospendi</a>--%>
					</td >
					  
                              
					<td>

						<select class ="center" name="task_<%=tasks.getIdtask()%>">
							<%for(Nodo nodo:listaNodi){%>
								<option value="<%=nodo.getIdnodo()%>"<%
								if(nodo.getIdnodo()==tasks.getIdnodo()){
									out.print("selected");
								}%>><%=nodo.getIdnodo()%></option>
								
							<%}%>
		                   		<option value="/" <%
								if(tasks.getIdnodo()==0){
									out.print("selected");
								}%>>/</option>
						</select>
						
					</td>
               
				</tr>
                    <% }%>
				</tbody>
			</table>
		</div>
		
		<input type="submit" value="AssociaTasks" name="mode" >
                
	</form>
     
</body>
</html>