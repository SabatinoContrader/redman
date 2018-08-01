<html>
<head>
<title>Login Trader</title>
</head>
<body>
   <div>
     <form action = "NodesServlet" method= "post" style="text-align: center;">
     <fieldset>
     <h3 align="center">Inserisci Nuovo Nodo</h3>
     <input type = "text" id = "id" name ="idNodo" placeholder = "inserisci id nuovo nodo"><br>
     <input type = "text" id = "info" name ="infonodo" placeholder = "inserisci info nuovo nodo"><br>
     <input type = "text" id = "gruppo" name ="gruppi_idgruppo" placeholder = "inserisci gruppo di appartenenza"><br>
     <br>
     <button type = "submit" value = "InsertNodoAdmin" name = "mode">Registra Nuovo Nodo</button><br>
     </fieldset>
     </form>
   </div>
</body>
</html>