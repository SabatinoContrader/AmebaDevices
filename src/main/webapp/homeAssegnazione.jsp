<%@ page import="com.pCarpet.model.Assegnazione" %>
<%@ page import="com.pCarpet.model.User" %>
<%@ page import="com.pCarpet.model.Badge" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
 <!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">


     <% List<Assegnazione> allAssegnazioni = (List<Assegnazione>) request.getAttribute("visualAssegnazioni");%>
 	<% List<User> allUsers = (List<User>) request.getAttribute("visualUsers");%>
 	<% List<Badge> allBadges = (List<Badge>) request.getAttribute("visualBadges");%>
 </head>
 <body class="text-center">
 <table class="bordo rcorners" width="500px">
 <tr><th><h4>ASSEGNAZIONI</h4></th></tr>
     <tr>
         <th>
             ID User
         </th>

         <th>
             ID Badge
         </th>
         <th>
             Data Assegnazione
         </th>
       


     </tr>
        <%for (Assegnazione ass : allAssegnazioni) { %>
     <tr>

         <td>
             <%= ass.getIdUtente()%>
         </td>

         <td>
             <%=  ass.getIdBadge()%>
         </td>

         <td>
             <%=  ass.getData()%>
         </td>

    
          
         <td>
            <a class="btn lg btn-primary" href="/Assegnazione/homeAssegnazione?scelta=rimuovi&idUser=<%=  ass.getIdUtente()%>&idBadge=<%=ass.getIdBadge() %>">Rimuovi</a>
         </td>

     </tr>
     <% }%>
 </table>
  </br>
 </form>
 
<form action="/Assegnazione/homeAssegnazione" method="post" class="form-signin">
 
  <table class="bordo rcorners" width="500px">
     <tr>
     <th><h4>USERS</h4></th><td></td><td></td><td></td><td></td><td class="userimg"></td></tr>
     <tr>
     
     	<th>
     	</th>
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
			<input type="radio" name="user" value="<%= u.getIduser()%>"/>
		</td>
		
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
 
 
 </br>
 
  <table class="bordo rcorners" width="500" border="0">
  <tr>
  <th><h5 align="left">BADGES LIBERI</h5></th><td></td><td></td><td class="imgB"></td>
  </tr>
     <tr>
     	<th>
     		
     	</th>
         <th>
             ID Badge
         </th>


         <th>
             Descrizione
         </th>
         <th>
             Tipologia
         </th>


     </tr>
        <%for (Badge b : allBadges) { %>
     <tr>
		
		<td>
		
		<input type="radio" name="badge" value="<%= b.getIdBadge()%>"/>
		</td>
		
         <td>
             <%= b.getIdBadge()%>
         </td>

         <td>
             <%=  b.getDescrizione()%>
         </td>


         <td>
             <%=  b.getTipologia()%>
         </td>

          

     </tr>
     <% }%>
 </table>
  </br>
<p align="left">
 <button class="btn btn-lg btn-primary" type="submit" value="insert" name="scelta">Assegna</button>
</p>
 </form>
 
 <form action="/Assegnazione/homeAssegnazione" method=get class="form-signin">
 <p align="left">
<button class="btn lg btn-primary" type="submit" value="indietro" name="scelta">Indietro</button>
</p>
</form>
 <h3></h3>


 </body>
</html>