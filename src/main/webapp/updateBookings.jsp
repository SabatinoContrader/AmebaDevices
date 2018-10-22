<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">

</head>
<body>
	

	<h2>Modifica la prenotazione</h2>
 
 </br>
 
<form action="/HomePrenotazione/showPrenotazione" method="post">
        
<table class="bordo rcorners">	
	<tr>
        
         <th>
             ID UTENTE
         </th>

         <th>
             ID ASSET
         </th>
         
         <th>
             ORA INIZIO
         </th>
         
         <th>
             ORA FINE
         </th>
         

	</tr>
	<tr>
	
        <td>
            ${p.iduser}
         </td>

		<td width="100px">
             ${p.idasset}
         </td>
         
         <td width="200px">
             ${p.orainizio}
         </td>

         <td width="200px">
             ${p.orafine}
         </td>

         
         
     </tr>
   
     
</table>

</br>

<table>	

	<tr>
	
		<td>
			<input type = "radio" value="orainizio" name="campo">Ora inizio
		</td>
		
		<td>
			<input type = "radio" value="orafine" name="campo">Ora fine
		</td>
		
		
		
		
		
<!--  		<td>
			<h4>Inserisci l'id dell'utente da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
		</td>
		-->
		
		
	</tr>

</table>

</br>

<h4>Inserisci il valore del nuovo campo: </h4>

<input type="datetime-local" id = "nuovoCampo" name="nuovoCampo" required autofocus>
		
</br>

<input type="hidden" name="id1" value="${p.iduser}"/>
<input type="hidden" name="id2" value="${p.idasset}"/>
<input type="hidden" name="id3" value="${p.orainizio}"/>
<input type="hidden" name="orafine" value="${p.orafine}"/>
<button class="btn btn-lg btn-primary" type="submit" value="update" name="choice">Effettua Modifica</button>

<a class="btn btn-lg btn-primary" 
		href="/HomeUser/showUsers?choice=indietroManagementUser">Indietro</a></br>


 <c:choose>
     
			<c:when test="${feedback == 'success'}">
				<div class="alert alert-success">
    				<strong>Success!</strong> Registrazione effettuata con successo.
  				</div>
			</c:when>
			
			<c:when test="${feedback == 'wrong'}">
				<div class="alert alert-danger">
    				<strong>Error!</strong> Prenotazione già presente o data errata, riprova.
  				</div>
			</c:when>
			
</c:choose>

</form>


</body>
</html>