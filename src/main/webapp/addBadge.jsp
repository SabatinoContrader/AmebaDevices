<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>
<h2><center>------- INSERT BADGE -------</center></h2>


	<h3>Inserisci i dati del badge</h3>
     <form action="/Badge/addBadge" method="post">
     	
     	 <table>
     	 
     	 <tr><th><h4>Inserimento Badge</h4></th><td class="imgB"></td><td></td> </tr>
     	 <tr>
     	<th>Descrizione: </th><td><input type = "text" id = "user" name ="descrizione" placeholder = "inserisci descrizione"></td></tr>
     	<tr>
     	<th>
     	Tipologia:</th><td> <input type = "text" id = "user" name ="tipologia" placeholder = "inserisci tipologia"></td></tr>
     	
		</table>
		<table>
		<tr>
		<td>	
		<button class="btn lg btn-primary" type="submit">Inserisci Badge</button>
		</td><td>
		<a class="btn lg btn-primary" 
		href="/Badge/HomeBadge?scelta=indietrobadgemanagement">Indietro</a></br>
     </td></tr>
     </table>
     	
     	
     </form>
	
</body>
</html>