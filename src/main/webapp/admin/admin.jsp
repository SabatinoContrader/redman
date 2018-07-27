<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>admin</h1>
<form action = "RegisterServlet" method= "post">
<h2>username: <input type = "text" id = "user" name ="username"></h2>
<h2>password: <input type = "text" id = "pass" name ="password"></h2>
<h2>ruolo: <input type = "text" id = "role" name ="ruolo"></h2>
<button type = "submit" value = "Register" name = "pulsante">Registra Utente</button><br>
</form>
</body>
</html>
