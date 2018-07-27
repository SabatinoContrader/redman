<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<head> 
<title>Responsabile</title> 
</head> 
<body> 
     <h1 align="center">MENU <br>*** RESPONSABILE *** <%= request.getSession().getAttribute("utente")%></h1> 
     
     <h3>1) Gestione utenti</h3> 
     <form action="HomeServlet" method="post"> 
     <input type="submit" value="ViewListProduct" name="mode"> 
     </form> 

     <h3>2) Gestione nodi</h3> 
     <form action="NodesServlet" method="post"> 
     <input type="submit" value="ViewListProduct" name="mode"> 
     </form> 

     <h3>3) Gestione task</h3> 
     <form action="" method="post"> 
     <input type="submit" value="SearchProduct" name="mode"> 
     </form> 
 
     <h3>4) Modifica profilo personale<h3> 
     <form action="" method="post"> 
     <input type="submit" value="SearchProduct" name="mode"> 
     </form> 
 
	 <h3>5) Logout<h3> 
     <form action="LogoutServlet" method="post"> 
     <input type="submit" value="Logout" name="Logout"> 
     </form> 
</body> 
</html> 
