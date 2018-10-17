<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Elimina Customer</title>
</head>
<body>
<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/remove-user.png"
			style="width: 5%; padding-right:2%;"> 
			<h2>Delete Customer</h2> </br>
	</div>
	<h3>Seleziona l'id del customer da eliminare</h3>
	  <form action = "Customer" method= "post">
		<div>Id Customer:
			<select name="idselected">
			<c:forEach var="customer" items="${customers}">
<option value="${customer.id}">${customer.id}
</option>			
			</c:forEach>
			</select>
		</div></br>
		</br>
		<button type = "submit" name="mode" value="DeleteDb"> Elimina</button>
	</form>
</body>

</html>