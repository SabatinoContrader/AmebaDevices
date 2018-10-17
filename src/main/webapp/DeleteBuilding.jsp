<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<h2>ELIMINA BUILDING</h2>
<body>
<div>
 <form action = "Building" method= "post">
 <table>
		<thead>
			<tr>
				<th>id</th>
				<th>indirizzo</th>
				<th>citta</th>
				<th>cap</th>
				<th>interno</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="building" items="${buildings}">
			<tr>
				<th>${building.buildingId}</th>
				<th>${building.indirizzo}</th>
				<th>${building.citta}</th>
				<th>${building.cap}</th>
				<th>${building.interno}</th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
 	<div>Id Building:
			<select name="idselected">
				<c:forEach var="building" items="${buildings}">
						<option value="${building.buildingId}">${building.buildingId}</option>
				</c:forEach>
			</select>
			
		</div>
	
	<button type ="submit" value="Delete" name="richiesta">Elimina</button><br>
	</form>

   </div>
</body>
</html>