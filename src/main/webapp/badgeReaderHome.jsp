<%@ page import="com.pCarpet.model.BadgeReader" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
  <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
     <% List<BadgeReader> allBadgeReaders = (List<BadgeReader>) request.getAttribute("visualizzaBadgeReaders");%>
 </head>
 <body>
<form action="/BadgeReader/homeBadgeReader" method="POST">
    <input type="submit" class="btn lg btn-primary" value="insert" name="scelta">
</form>
<form action="/BadgeReader/homeBadgeReader" method="GET">
 <table class="border rcorners">
  <tr><th><h4>BADGE READERS</h4></th><TD></TD><TD></TD><TD></TD></tr>
 
     <tr>
         <th>
             ID Badge Reader
         </th>

         <th>
             ID Asset
         </th>
         <th>
             Descrizione
         </th>
         <th>
             Tipologia
         </th>


     </tr>
        <%for (BadgeReader badgeReader : allBadgeReaders) { %>
     <tr>
         <td>
             <%= badgeReader.getIdBadgeReader()%>
         </td>

         <td>
             <%=  badgeReader.getIdAsset()%>
         </td>

         <td>
             <%=  badgeReader.getDescrizione()%>
         </td>

         <td>
             <%=  badgeReader.getTipologia()%>
         </td>

</form>
     </tr>
     <% }%>
 </table>
 <form action="/BadgeReader/homeBadgeReader" method=get>
<button type="submit" class="btn lg btn-primary" value="indietro" name="scelta">Indietro</button>
</form>
 <!-- <h3><a href="insertProdotto.jsp">1. - Inserisci nuovo Asset</a></h3> -->
 <!-- <input type="text" value="Scelta" name="richiesta">
 <button type = "submit" value = "Vai" name = "pulsante">GO</button> -->
 <h3></h3>

 </form>
 </body>
</html>