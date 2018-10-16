<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Customer</title>
</head>
<body>
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
		<button type = "submit"> Elimina</button>
		<input hidden name="mode" value="DeleteDb">
	</form>
</body>

</html>