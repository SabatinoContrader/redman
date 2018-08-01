<html>
<head>
<title>Login Trader</title>
</head>
<body>
   <div>
     <form action = "UtentiServlet" method= "post" style="text-align: center;">
     <fieldset>
     <h3 align="center">Inserisci Nuovo Utente</h3>
     <input type = "text" id = "id" name ="idUser" placeholder = "inserisci id nuovo utente"><br>
     <input type = "text" id = "user" name ="username" placeholder = "inserisci username nuovo utente"><br>
     <input type = "text" id = "pass" name ="password" placeholder = "inserisci password nuovo utente"><br>
     <input type = "text" id = "role" name ="ruolo" placeholder = "inserisci ruolo nuovo utente"><br>
     <br>
     <button type = "submit" value = "Register" name = "mode">Registra Nuovo Utente</button><br>
     </fieldset>
     </form>
   </div>
</body>
</html>