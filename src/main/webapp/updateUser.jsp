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
        
<table class="bordo rcorners">	
	<tr>
        
         <th>
             ID UTENTE
         </th>

         <th>
             USERNAME
         </th>
         
         <th>
             PASSWORD
         </th>
         
         <th>
             NOME
         </th>
         <th>
             COGNOME
         </th>
         <th>
             TELEFONO
         </th>
         <th>
            EMAIL
         </th>
         <th>
             PARTITA IVA
         </th>
         <th>
            RUOLO
          </th>
			 <th>
            NOME ABBONAMENTO
          </th>
	</tr>
	<tr>
	
        <td>
            ${user.iduser}
         </td>

		<td>
             ${user.username}
         </td>
         
         <td>
             ${user.password}
         </td>

         <td>
             ${user.nome}
         </td>

         <td>
             ${user.cognome}
         </td>

         <td>
             ${user.telefono}
         </td>
         <td>
             ${user.mail}
         </td>
         <td>
             ${user.partitaiva}
         </td>
         <td>
            ${user.ruolo}
         </td>
          <td>
            ${user.nomeAbb}
         </td>
     </tr>
   
     
</table>

</br>

<table>	

	<tr>
	
		<td>
			<input type = "radio" value="username" name="campo">Username
		</td>
		
		<td>
			<input type = "radio" value="password" name="campo">Password
		</td>
		
		<td>
			<input type = "radio" value="nome" name="campo">Nome
		</td>
		
		<td>
			<input type = "radio" value="cognome" name="campo">Cognome
		</td>
		
		<td>
			<input type = "radio" value="telefono" name="campo">Telefono
		</td>
		
		<td>
			<input type = "radio" value="mail" name="campo">Mail
		</td>
		
		<td>
			<input type = "radio" value="partitaiva" name="campo">Partita Iva
		</td>
		
		<td>
			<input type = "radio" value="ruolo" name="campo">Ruolo
		</td>
		<td>
			<input type = "radio" value="nomeAbb" name="campo">Nome Abbonamento
		</td>
		
		
		
<!--  		<td>
			<h4>Inserisci l'id dell'utente da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
		</td>
		-->
		
		
	</tr>

</table>

</br>

<h4>Inserisci il valore del nuovo campo: 
<input type = "text" id = "nuovoCampo" name ="nuovoCampo" placeholder = "inserisci nuovo campo" required autofocus></h4>
		
</br>

<input type="hidden" name="id" value="${user.iduser}"/>
<button class="btn btn-lg btn-primary" type="submit" value="update" name="choice">Effettua Modifica</button>

<a class="btn btn-lg btn-primary" 
		href="/HomeUser/showUsers?choice=indietroManagementUser">Indietro</a></br>

</form>

</body>
</html>