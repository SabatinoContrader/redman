<html>
<head>
<title>Login Trader</title>
</head>
<body>
   <div>
     <form action = "LoginTraderServlet" method= "post" style="text-align: center;">
     <fieldset>
     <h3 align="center">Login</h3>
     <input type = "text" id = "user" name ="username" placeholder = "inserisci username"><br>
     <input type = "text" id = "pass" name ="password" placeholder = "inserisci password"><br>
     <br>
     <button type = "submit" value = "Login" name = "pulsante">Login In</button><br>
     <a href="UtentiServlet"> Gestione Utenti </a>
     </fieldset>
     </form>
   </div>
</body>
</html>