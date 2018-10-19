<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/Thing">
     	<jsp:param name="operation" value="ReadThing"/>
     </jsp:include>
<p> 
	   	<h2>------- MENU THING-------</h2>
	</p>
	<p>
		<ol>
  			<li> 
  				<a href="Thing?operation=create">
  				Inserisci thing
  				</a> 
  			</li>
  			<li> 
  				<a href="Thing?operation=update">
  				Modifica thing
  				</a>
  			</li>
  			<li>
				<a href="Thing?operation=DeleteFormThing">
  				Elimina thing
  				</a>
  			</li>
		</ol> 
	</p>
     <jsp:include page="HeaderLogout.jsp"/>
<!--  <form action="Thing" method="post">
	<select id="operations" name="operation">
  		<option value="create">Crea Thing</option>
	</select>
	<button type="submit">Submit</button><br>
</form>
-->


</body>
</html>