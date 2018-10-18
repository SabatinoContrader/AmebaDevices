<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
<jsp:include page="/Building">
     	<jsp:param name="richiesta" value="VisualizzaBuildings"/>
     </jsp:include>
<p> 
	   	<h2>------- MENU BUILDING -------</h2>
	</p>
	<p>
		<ol>
  			<li> 
  				<a href="Building?richiesta=InserisciBuilding">
  				Inserisci building
  				</a> 
  			</li>
  			<li> 
  				<a href="Building?richiesta=ModificaBuilding">
  				Modifica building
  				</a>
  			</li>
  			<li>
				<a href="Building?richiesta=EliminaBuilding">
  				Elimina building
  				</a>
  			</li>
		</ol> 
	</p>
     <jsp:include page="HeaderLogout.jsp"/>
</body>
</html>