<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.model.Item"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Room Menu</title>
<link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
<a href="/Room/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
</head>
<body>
	<h1>Room Menu</h1>
<%String roomId= request.getParameter("roomId"); %>
	<h2 class="things">Item della room con id <%=roomId%> </h2>
	 	<div class="thingDiv">
	<table class="thingTable table" style="margin-top:-15%;">
	<tr><th>Id: </th>
	<th>ConsumoEnergetico: </th>
	<th>Seriale: </th>
	<th>IdRoom: </th>
	<% List <Item> item = (List <Item>) request.getAttribute("items"); for (int i=0; i < item.size(); i++) { %>
		<tr>	<td align="center"><a style="color:white; text-decoration:none" href="/Item/menu"><% out.println(item.get(i).getId()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"href="/Item/menu"><% out.println (item.get(i).getConsumoEnergetico());%></a></td>
							<td align="center"><a style="color:white; text-decoration:none"href="/Item/menu"><% out.println (item.get(i).getSeriale()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"href="/Item/menu"> <% out.println (item.get(i).getRoom().getId()); %></a></td>
		</tr>								
	<%}%>
	</table>
	
		<div>
			<div class="insertDiv">
				<img src="http://www.aa24.it/wp-content/uploads/2015/03/1426101814_add-notes.png"
					class="imgThing"> <a class="customerLink"
					href="/Item/insertForm?roomId=<%=roomId%>"> Aggiungi item </a>
			</div>
		
			<div class="insertDiv">
				<img src="http://icongal.com/gallery/image/43791/edit_notes_delete.png"
					class="imgThing"> <a class="customerLink"
					href="/Item/updateForm?roomId=<%=roomId%>">Modifica item </a>
			</div>
				<div class="insertDiv">
				<img src="https://www.shareicon.net/data/512x512/2015/05/10/36482_delete_512x512.png"
					class="imgThing"> <a class="customerLink"
					href="/Item/deleteForm?roomId=<%=roomId%>"> Elimina item </a>
			</div>
				
		</div>
	</div>

</body>
</html>