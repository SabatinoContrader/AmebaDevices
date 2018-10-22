<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.model.Asset"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento Asset</title>
<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">
</head>
<body>
 <h2>Inserisci i dati dell'asset</h2>
 
 </br>
 
     <form action="/Asset/homeAsset?scelta=insert" method="post">
     
     	
     
     <table class="border rcorners">
       <tr><th><h4 align="left">Inserimento asset</th><td></td><td></td><td ></td></tr>
     
     	<tr><th>Tipo:</th> <td><input type = "text" id = "asset" name ="tipo" placeholder = "inserisci il tipo" required autofocus></td></tr>
     	
     	<tr><th>Descrizione:</th> <td><input type = "text" id = "asset" name ="descrizione" placeholder = "inserisci la descrizione" required autofocus></td></tr>
     	
     	<tr><th>Prezzo:</th> <td><input type = "text" id = "asset" name ="prezzo" placeholder = "inserisci il prezzo" required autofocus></td></tr>
     	

		<%-- ${Asset a = new Asset(0,tipo,descrizione, prezzo)}
         <input type="hidden" name="Asset" value="${a}"/> --%>
		
     	<%-- <a class="btn btn-lg btn-primary btn-block"
			href="/Asset/homeAsset?choice=insertAsset&Asset=${u}">Inserisci</a> --%>
	</table>
	<table>
		<tr><td><button class="btn lg btn-primary" type="submit">Inserisci</button></td><td>
		
		<a class="btn lg btn-primary" 
		href="/Asset/homeAsset?scelta=indietro">Indietro</a></td></tr>
     </table>
     </form>
</body>
</html>