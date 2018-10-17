<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<h2>MODIFICA BUILDING</h2>
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
	<h3>Inserire indirizzo building: <input type="text" name="newindirizzo" placeholder="inserire indirizzo building"></h3>
	<h3>Inserire interno building: <input type="text" name="newinterno" placeholder="inserire interno"></h3>
	<h3>Inserire città building: <input type="text" name="newcitta" placeholder="inserire citta"></h3>
	<h3>Inserire cap building: <input type="text" name="newcap" placeholder="inserire cap"></h3>
	<button type ="submit" value="UpdateBuilding" name="richiesta">Modifica</button><br>
	</form>

   </div>
</body>
</html>