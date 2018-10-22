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
 <h2>Inserisci i dati dell'utente</h2>
 
 </br>
 
     <form action="/HomeUser/showUsers" method="post">
     
     	
     
        <table class="border rcorners">
        <tr><th><h4>Inserimento User</h4></th><td class="userimg"></td><td></td><td></td></tr>
        <tr>
     	<th>Username:</th> <td><input type = "text" id = "user" name ="username" placeholder = "inserisci username" required autofocus></td></tr>
     	
     	<tr><th>Password:</th> <td> <input type = "password" id = "user" name ="password" placeholder = "inserisci la password" required autofocus></td></tr>
     	
     	<tr><th>Nome:</th> <td> <input type = "text" id = "user" name ="nome" placeholder = "inserisci nome" required autofocus></td></tr>
     	
     	<tr><th>Cognome:</th> <td> <input type = "text" id = "user" name ="cognome" placeholder = "inserisci cognome" required autofocus></td></tr>
     	
     	<tr><th>Telefono:</th> <td> <input type = "text" id = "user" name ="telefono" placeholder = "inserisci telefono" required autofocus></td></tr>
     	
     	<tr><th>Mail:</th> <td> <input type = "text" id = "user" name ="mail" placeholder = "inserisci mail" required autofocus></td></tr>
     	
     	<tr><th>Partita iva:</th> <td> <input type = "text" id = "user" name ="partitaiva" placeholder = "inserisci partita iva" required autofocus></td></tr>
     	
     	<tr><th>Ruolo:</th> <td> <input type = "text" id = "user" name ="ruolo" placeholder = "inserisci ruolo" required autofocus></td></tr>

		<tr><th>Nome Abbonamento:</th> <td>
		<select id="user" name = "nomeAbb">
		<option value ="gold">gold</option>
		<option value ="silver">silver</option>
		<option value ="normale">normale</option>
		<option value ="business">business</option></select>
		</td></tr>

		<%-- ${User u= new User(0,username,password,nome,congome,telefono,mail,partitaiva,ruolo,nomeAbb)}
         <input type="hidden" name="User" value="${u}"/> --%>
		
     	<%-- <a class="btn btn-lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=insertUser&User=${u}">Inserisci</a> --%>
			
		<button class="btn lg btn-primary" type="submit" value="insert" name="choice">Inserisci</button>
		
		<a class="btn lg btn-primary" 
		href="/HomeUser/showUsers?choice=indietroManagementUser">Indietro</a></br>
     </table>
     </form>
</body>
</html>