<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.virtualpairprogrammers.model.Thing"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Questa è la jsp che ti permette di modificare una thing </h1>
	<table>
	<%		List<Thing> things = (List<Thing>) request.getAttribute("things");

					for (int i=0; i < things.size(); i++) {
						%><tr>	
						<td><% out.println(things.get(i).getId()); %></td>
						<td><% out.println(things.get(i).getNumUscite()); %></td>
						<td><% out.println(things.get(i).getNome()); %></td>
						</tr>
									
	<%} %>
	</table>
	<h2>Quale thing vuoi modificare?</h2>
	<form action="Thing?thingid=<%= request.getParameter("thingid") %>&operation=sendDataForUpdate" method="post">
	<select id="id" name="thingId">
	<% for (int i=0; i < things.size(); i++) { %>
  		<option value="<%=things.get(i).getId()%>"><%=things.get(i).getId()%></option>
  	<%} %>
	</select>
	<h3>Inserire numero uscite: <input type="text" name="numberPort" placeholder="inserire numero uscite"></h3>
	<h3>Inserire nome thing: <input type="text" name="nameThing" placeholder="inserire nome thing"></h3>
	<button type ="submit" value="sendDataForUpdate" name="operation">Modifica</button><br>
</form>
</body>
</html>