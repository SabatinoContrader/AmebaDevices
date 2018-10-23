<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.AmebaDevices.model.Room"%>
<!DOCTYPE html>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Floor Home</title>
</head>
<body>
     <h1>------- FLOOR MENU del floor <%=request.getParameter("floorId")%> -------</h1>
     <h2>Le tue rooms</h2>
		<table class="table">
					<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>Descrizione</th>
							<th>IdFloor</th>
					</tr>
					<% 
					List <Room> rooms = (List <Room>) request.getAttribute("rooms");
					for (int i=0 ; i < rooms.size(); i++) { %>
						<tr>
							<td align="center"> <%=rooms.get(i).getId() %>
							<td align="center"><%=rooms.get(i).getNomeRoom()%></td>
							<td align="center"><%=rooms.get(i).getDescrizione() %>
							<td align="center"> <%=rooms.get(i).getIdFloor() %>
						</tr>
		<% }%>
		</table>	
	 <%String floorId= request.getParameter("floorId"); %>
	 <p>
		<ol>
  			<li> 
  				<a href="insertForm?floorId=<%=floorId%>">
  				Inserisci room
  				</a> 
  			</li>
  			<li> 
  				<a href="updateForm?floorId=<%=floorId%>">
  				Modifica room
  				</a>
  			</li>
  			<li>
				<a href="deleteForm?floorId=<%=floorId%>">
  				Elimina room
  				</a>
  			</li>
		</ol> 
	</p>
 </body>
 </html>