<%@ page import="com.pCarpet.model.Movimento" %>
<%@ page import="com.pCarpet.model.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
 <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<% List<User> allUsers = (List<User>) request.getAttribute("visualizzaUsers");%>
<meta charset="ISO-8859-1">
<title>Export</title>
</head>
<body>
<form action="/Movimento/homeMovimento" method="post">
<table>
<tr><td>
<h3>Inserire percorso dove si vuole esportare il file</h3></td></tr>
<tr>
<td>
<input type="text" name="dir"></td></tr>
<tr><td>
<h3>Inserire nome del file</h3></td></tr>
<tr>
<td>

<input type="text" name="name"></td></tr></table>
</br></br>
  <table class="border rcorners">
     <tr><th><h4>Users</h4></th><td></td><td></td><td></td><td class="userimg"></td></tr>
     
     <tr>
         <th>
             ID User
         </th>

         <th>
             Username
         </th>
         <th>
             Nome
         </th>
         <th>
             Cognome
         </th>
          <th>
             Partita Iva
         </th>


     </tr>
        <%for (User u : allUsers) { %>
     <tr>
		
         <td>
             <%= u.getIduser()%>
         </td>

         <td>
             <%=  u.getUsername()%>
         </td>

         <td>
             <%=  u.getNome()%>
         </td>

         <td>
             <%=  u.getCognome()%>
         </td>
         
          <td>
             <%=  u.getPartitaiva()%>
         </td>

        

     </tr>
     <% }%>
 </table>
<tr><td>
<h3>Se si vuole esportare i movimenti relativi ad un utente specifico inserire l'id,<br> altrimenti premere Esporta per esportare i movimenti e le prenotazioni di tutti gli utenti</h3></td></tr>
<tr>
<td>
<input type="text" name="scelta"></td></tr>

 <form action="/Movimento/homeMovimento" method=post>
<table>
<tr>
<td>
<button type="submit" class="btn lg btn-primary" value="indietroHome" name="richiesta">Indietro</button>
</td>
<td><button type="submit" value="exportdue" class="btn lg btn-primary" name="richiesta">Esporta</button>
</td>
</tr>
</table>
</form>
</body>
</html>