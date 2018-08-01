<html>
<head>
<title>Login Trader</title>
</head>
<body>
   <div>
     <form action = "UtentiServlet" method= "post" style="text-align: center;">
     <fieldset>
     <h3 align="center">Inserisci Nuovo Utente</h3>
     <input type = "text" id = "id" name ="idUser" placeholder = "id nuovo utente"><br>
     <input type = "text" id = "user" name ="username" placeholder = "username nuovo utente"><br>
     <input type = "text" id = "pass" name ="password" placeholder = "password nuovo utente"><br>
     <input type = "text" id = "role" name ="ruolo" placeholder = "ruolo nuovo utente"><br>
     <br>
     <button type = "submit" value = "InsertUtenteAdmin" name = "mode">Registra Nuovo Utente</button><br>
     </fieldset>
     </form>
   </div>
</body>
</html>