<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.model.ItemType"%>
<!DOCTYPE html>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="/resources/css/styles.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Item</title>
</head>
<body>
<a href="/ItemType/menu" class="logout">Indietro</a>
<jsp:include page="HeaderLogout.jsp"></jsp:include>
<div class="readCustomer">
		<img src="https://png2.kisspng.com/show/812fa857dddd93107f5556efc9640d62/L0KzQYm3UcMxN6d2fZH0aYP2gLBuTgRma5lzh954Z4mwdcbqjPllbZJzRehuY4Tygn7wgB9vNZpoh9C2b3awebB7hgJvbaUyh9g2dHjsfrj6TgRma5lzh954Z4mwRbKAUMJmbGU4T6hrMkSxQIq5UsA3OWU2TaMCM0C0RIe3UsI4NqFzf3==/kisspng-technology-euclidean-vector-icon-icon-of-internet-of-things-technology-5a702ed4376b24.092206141517301460227.png"
			class="imgItem">
	 <h1>------- MENU delle room <%=request.getParameter("roomId")%> -------</h1>
     <h2>I tuoi itemType</h2>
		<table class="table">
		<tr>
		<th> id</th>
		<th>categoria</th>
		<th>descrizione</th>
		<th>marca</th>
		<th>modello </th>
		</tr>
		<%
		List <ItemType> item = (List <ItemType>) request.getAttribute("items");
					for (int i=0 ; i < item.size(); i++) { %>
						<tr>
							<td align="center"><a style="color:white; text-decoration:none" href="/Item/menu"><% out.println(item.get(i).getId()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"href="/Item/menu"><% out.println (item.get(i).getCategoria());%></a></td>
							<td align="center"><a style="color:white; text-decoration:none"href="/Item/menu"><% out.println (item.get(i).getDescrizione()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"href="/Item/menu"> <% out.println (item.get(i).getMarca()); %></a></td>
							<td align="center"><a style="color:white; text-decoration:none"href="/Item/menu"> <% out.println (item.get(i).getModello()); %></a></td>
						</tr>
		<% }%>
		</table>	
		 <%String roomId= request.getParameter("roomId"); %>
		
	
	</div>
	<div class="itemDiv">
	<div class="insertDiv">
		<img src="http://www.aa24.it/wp-content/uploads/2015/03/1426101814_add-notes.png"
			class="imgSuperUser" > <a href="/ItemType/insertForm?roomId=<%=roomId%>"
			class="customerLink">Censimento item </a>
	</div>
	<div class="insertDiv">
		<img src="https://cdn4.iconfinder.com/data/icons/meBaze-Freebies/512/notes.png"
			class="imgSuperUser" > <a href="/ItemType/read?roomId=<%=roomId%>"
			class="customerLink">Visualizza items </a>
	</div>
	<div class="insertDiv">
		<img src="http://icongal.com/gallery/image/43791/edit_notes_delete.png"
			class="imgSuperUser" > <a href="/ItemType/updateForm?roomId=<%=roomId%>"
			class="customerLink">Modifica item </a>
	</div>
	<div class="insertDiv">
		<img src="https://www.shareicon.net/data/512x512/2015/05/10/36482_delete_512x512.png"
			class="imgSuperUser" > <a href="/ItemType/deleteForm?roomId=<%=roomId%>"
			class="customerLink">Elimina item </a>
	</div>
	</div>
	
	

</body>
</html>