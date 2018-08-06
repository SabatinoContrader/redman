<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica profilo</title>
</head>
<body>
	<form action="ModifyProfileServlet" method="post" style="text-align: center;">
		<fieldset>
			<h3 align="center">Modifica profilo personale</h3>
			<input type="text" id="user" name="username"placeholder="inserisci nuovo username"><br> 
			<input type="text" id="pass" name="password"placeholder="inserisci nuova password"><br> <br>
			<button type="submit" value="ModifyProfile" name="mode">Modifica</button>
			<button type="submit" value="back" name="mode" >Annulla</button>
			<br>
		</fieldset>

    	
    </form>
	
</body>
</html>