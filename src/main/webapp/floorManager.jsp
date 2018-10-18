<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Floor">
     	<jsp:param name="operation" value="read"/>
     </jsp:include>

<h2>------- MENU FLOORS -------</h2>
	 <%String buildingId= request.getParameter("buildingId"); %>
	 <p>
		<ol>
  			<li> 
  				<a href="Floor?operation=create&buildingId=<%=buildingId%>">
  				Inserisci floor
  				</a> 
  			</li>
  			<li> 
  				<a href="Floor?operation=update&buildingId=<%=buildingId%>">
  				Modifica floor
  				</a>
  			</li>
  			<li>
				<a href="Floor?operation=delete&buildingId=<%=buildingId%>">
  				Elimina floor
  				</a>
  			</li>
		</ol> 
	</p>
	
<!--  <form action="Floor" method="post">
	<select id="operations" name="operation">
  		<option value="create">Crea Floor</option>
    	<option value="read">Visualizza Floor</option>
   		<option value="update">Modifica Floor</option>
   		<option value="delete">Cancella Floor</option>
	</select>
	<button type="submit">Submit</button><br>
</form>-->


</body>
</html>