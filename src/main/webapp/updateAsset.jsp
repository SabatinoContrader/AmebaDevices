<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.model.Asset"%>
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

<h2>Inserisci i dati dell'asset</h2>
 
 </br>
 
<form action="/Asset/homeAsset" method="post">
        
<table class="border rcorners">	

	<tr>
        
         <th>
             Id Asset
         </th>

         <th>
             Descrizione
         </th>
         
         <th>
             Tipo
         </th>
         
         <th>
             Prezzo
         </th>

	</tr>
	<tr>
	
        <td>
            ${asset.idAsset}
         </td>

		<td>
             ${asset.tipo}
         </td>
         
         <td>
             ${asset.descrizione}
         </td>

         <td>
             ${asset.prezzo}
         </td>
         
     </tr>
   
     
</table>

</br>

<table>	

	<tr>
		
		<td>
			<input type = "radio" value="tipo" name="campo" >Tipo
		</td>
		
		<td>
			<input type = "radio" value="descrizione" name="campo">Descrizione
		</td>
		
		<td>
			<input type = "radio" value="prezzo" name="campo">Prezzo
		</td>
		
	
		
		
<!--  		<td>
			<h4>Inserisci l'id dell'utente da modificare: <input type = "text" id = "user" name ="id" placeholder = "inserisci id"></h4>
		</td>
		-->
		
		
	</tr>

</table>

</br>
<table>
<tr><th>
<h4>Inserisci il valore del nuovo campo:</h4></th> 
</tr><tr>
<td>
<input type = "text" id = "nuovoCampo" name ="nuovoCampo" placeholder = "inserisci nuovo campo" required autofocus>
</td>
</tr>
</table>		
</br>

<input type="hidden" name="id" value="${asset.idAsset}"/>
<table>
<tr><td>
<button class="btn lg btn-primary" type="submit" value="update" name="scelta">Effettua Modifica</button>
</td><td>
<a class="btn lg btn-primary" 
		href="/Asset/homeAsset?scelta=indietro">Indietro</a></br>
</td>
</tr>
</table>
</form>

</body>
</html>