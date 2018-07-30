<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.virtualpairprogrammers.model.Nodo" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>



<html>
 <head>
     
     
     <% List<Nodo> allnodes =(List<Nodo>) request.getAttribute("Nodo");%>
 </head>
 <body>
 <h1>Benvenuto <%= request.getSession().getAttribute("Utente")%></h1>


<form action="NodesServlet" method="post">
 <table>
 <tr>
   <td>
      NODI:
   </td>
   <td>
   </td>
   </td>
   </tr>
     <tr>
        <th></th>
         <th>
             ID_CODICE
         </th>

         <th>
             UTENTE
         </th>
         <th>
             INFORMAZIONI
         </th>
         <th>
             STATO
         </th>
         <th>
             GRUPPO
         </th>
         <th>
          </th>
         <th>
          </th>

     </tr>
         
 </table>
<%-- <input type="submit" value="SellProducts" name="richiesta"> <a href="home.jsp">Home <h3><a href="insertProdotto.jsp">Inserisci Prodotto</a></h3>
</form>
 <h2></h2>
 <h2></h2>
 <form action="" method="post">
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci un nuovo Prodotto</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>--%>
 </body>
</html>




