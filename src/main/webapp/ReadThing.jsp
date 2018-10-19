<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1" %>
<%@ page import="com.virtualpairprogrammers.model.Thing"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% List<Thing> things = (List<Thing>) request.getAttribute("things");%>
</head>
<body>
<h2>Things</h2>
		<table class="table">

					<tr>
							<th>Id</th>
							<th>numUscite</th>
							<th>Nome</th>

					</tr>

					<%for (Thing thing : things) { %>
						<tr>
							<td align="center"> <%=thing.getId() %>
							<td align="center"> <%=thing.getNumUscite() %>
							<td align="center"><%=thing.getNome() %>
						</tr>
		<% }%>
		</table>
		
</body>
</html>