<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.virtualpairprogrammers.model.Floor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Questa è la jsp che ti visualizzare tutti i floor relativi al building <%=request.getAttribute("buildingId") %></h1>
	<table>
	<% 
										List<Floor> floors = (List<Floor>) request.getAttribute("floors");

										for (int i=0; i < floors.size(); i++) {
									%><tr>	<td><a href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getId()); %></a></td>
											<td><a href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getNomeFloor()); %></a></td>
											<td><a href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getDescrizione()); %></a></td>
											<td><a href="RoomServlet?richiesta=home&floorId=<% out.println(floors.get(i).getId()); %>"><% out.println(floors.get(i).getIdBuilding()); %></a></td>
									</tr>
									
	<%} %>
	</table>
</body>
</html>