<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/multy-user.png"
			style="width: 5%; padding-right:2%; ">
	<h2>Customers</h2>
	</div>
		<table class="table">
				<thead>
					<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Data Di Nascita</th>
							<th>Username</th>
							<th>Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${customers}">
						<tr>
							<th>${customer.id}</th>
							<td align="center">${customer.nome}</td>
							<td align="center">${customer.cognome}</td>
							<td align="center">${customer.dataNascita}</td>
							<td align="center">${customer.username}</td>
							<td align="center">${customer.password}</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		</br>
		<a href="Customer?mode=Return" style="color:black;">Torna alla home</a>
</body>
</html>