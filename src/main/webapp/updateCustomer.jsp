<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
<div style="display: flex; align-items: center;">
		<img src="http://cdn.onlinewebfonts.com/svg/img_244280.png"
			style="width: 5%; padding-right:2%;">
			<h2>Modifica Customer</h2>
	</div>
	<h3>Seleziona l'id del customer da modificare</h3>
	  <form action = "Customer" method= "post">
		<div>Id Customer:
			<select name="idselected">
				<c:forEach var="customer" items="${customers}">
						<option value="${customer.id}">${customer.id}</option>
				</c:forEach>
			</select>
			
		</div></br>
		<div>Cosa vuoi modificare?   &nbsp; 
			<select  name="selected">
  				<option value="1">Nome</option>
  				<option value="2">Cognome</option>
  				<option value="3">Data di Nascita</option>
  				<option value="4">Username</option>
 				 <option value="5">Password</option> 
			</select>
			&nbsp;&nbsp;
			<input type = "text" id = "value" name ="value" placeholder="Inserisci nuovo valore">
		</div></br>
		<button type = "submit" name="mode" value="UpdateDb"> Modifica</button>
	</form>
</body>

</html>