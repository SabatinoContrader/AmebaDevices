<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RoomHome</title>
</head>
<body>
<!--<jsp:include page="/Room/read">
     	<jsp:param name="richiesta" value="ReadRoom"/>
     </jsp:include>-->
     <h2>------- MENU ROOMS -------</h2>
	 <%String floorId= request.getParameter("floorId"); %>
	 <p>
		<ol>
  			<li> 
  				<a href="insertForm">
  				Inserisci room
  				</a> 
  			</li>
  			<li> 
  				<a href="updateForm">
  				Modifica room
  				</a>
  			</li>
  			<li>
				<a href="deleteForm">
  				Elimina room
  				</a>
  			</li>
		</ol> 
	</p>
<input hidden value=<%=request.getAttribute("floorId")%> >
 </body>
 </html>