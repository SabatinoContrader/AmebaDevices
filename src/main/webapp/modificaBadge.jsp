<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>

<h2>Inserisci i dati del badge</h2>
 
 </br>
 
<form action="/Badge/modificaBadge" method="post">
        
<table class="border rcorners">	
<tr><th><h4>Badges</h4></th><td></td><td class="imgB"></td></tr>
	<tr>
        
         <th>
             ID Badge
         </th>

         <th>
             Tipologia
         </th>
         
         <th>
             Descrizione
         </th>
         
         
	</tr>
	<tr>
	
        <td>
            ${badge.idBadge}
         </td>

		<td>
             ${badge.descrizione}
         </td>
         
         <td>
             ${badge.tipologia}
         </td>

         
     </tr>
   
     
</table>

</br>

<table>	

	<tr>
	
		<td>
			<input type = "radio" value="tipologia" name="campo">Tipologia
			
		</td>
		
		<td>
			<input type = "radio" value="descrizione" name="campo">Descrizione
		</td>
		
		
		
<!--  		<td>
			<h4>Inserisci l'id dell'utente da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
		</td>
		-->
		
		
	</tr>

</table>

</br>
<input type="hidden" name="id" value="${badge.idBadge}"/>
<table>
<tr>
<th>
<h4>Inserisci il valore del nuovo campo:</h4></th>
</tr>
<tr>
<td> 
<input type = "text" id = "nuovoCampo" name ="nuovoCampo" placeholder = "inserisci nuovo campo" required autofocus>
</td></tr>	
<tr>


<td>
<p align="left">
<button class="btn lg btn-primary" type="submit" value="${badge.idBadge}" name="id1">Effettua Modifica</button>
</p>
</td>
<td>
<a class="btn lg btn-primary" 
		href="/Badge/HomeBadge?scelta=indietrobadgemanagement">Indietro</a>
</td></tr>

</table>
</form>

</body>
</html>