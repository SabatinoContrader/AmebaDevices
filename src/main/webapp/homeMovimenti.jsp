<%@ page import="com.pCarpet.model.Movimento" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
  <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
     <% List<Movimento> allMovimenti = (List<Movimento>) request.getAttribute("visualizzaMovimenti");%>
 </head>
 <body>


 <table class="border rcorners">
     <tr><th><h4>Lista Movimenti</h4></th><td></td><td></td><td class="imgB"></td></tr>
     <tr>
     
         <th>
             ID Badge Reader
         </th>
         <th>
             ID Badge
         </th>
         <th>
             Data inizio
         </th>
         <th>
             Data fine
         </th>
		 </tr>
        <%for (Movimento movimento : allMovimenti) { %>
     <tr>
	<td>
             <%= movimento.getIdbadgereader()%>
         </td>
         <td>
             <%=  movimento.getIdbadge()%>
         </td>

         <td>
             <%=  movimento.getOrainizio()%>
         </td>

         <td>
             <%=  movimento.getOrafine()%>
         </td>
     </tr>
     <% }%>
 </table>
 </br>
 <table>
 <form action="/Movimento/homeMovimento" method=post>
<tr><td>
<button type="submit" value="indietroHome" class="btn lg btn-primary" name="richiesta">Indietro</button>
</td>
<td><button type="submit" value="export" class="btn lg btn-primary" name="richiesta">Esporta</button>
</td></tr>
</table>
</form>
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>