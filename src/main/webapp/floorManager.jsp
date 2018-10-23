<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.model.Floor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Floor Menu</title>
<link rel="stylesheet" href="styles.css">
<a href="CustomerHome.jsp" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Floor Menu</h1>
<% String buildingId = request.getParameter("buildingId"); %>
	<h2 class="things">Floor del building con id <%=buildingId%> </h2>
	 	<div class="thingDiv">
	<table class="thingTable table" style="margin-top:-15%;">
	<tr><th>Id: </th>
	<th>Nome: </th>
	<th>Descrizione: </th>
	<th>IdBuilding: </th></tr>
	<% List<Floor> floors = (List<Floor>) request.getAttribute("floors"); for (int i=0; i < floors.size(); i++) { %>
		<tr>	<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getId()); %></a></td>
				<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getNomeFloor()); %></a></td>
				<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getDescrizione()); %></a></td>
				<td align="center"><a style="color:white; text-decoration:none" href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getIdBuilding()); %></a></td>
		</tr>								
	<%}%>
	</table>
	
		<div>
			<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="insertForm?buildingId=<%=buildingId%>">Inserisci Floor </a>
			</div>
		<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="updateForm?buildingId=<%=buildingId%>">Modifica Floor </a>
			</div>
			<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="deleteForm?buildingId=<%=buildingId%>">Elimina Floor </a>
			</div>
				<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="download?type=xml&buildingId=<%=buildingId%>">Genera XML </a>
			</div>
				<div class="insertDiv">
				<img
					src="https://png2.kisspng.com/20180509/che/kisspng-computer-icons-building-cube-clip-art-5af29b46688608.6583202015258489024281.png"
					class="imgThing"> <a class="customerLink"
					href="download?type=csv&buildingId=<%=buildingId%>">Genera CSV </a>
			</div>
		</div>
	</div>

</body>
</html>