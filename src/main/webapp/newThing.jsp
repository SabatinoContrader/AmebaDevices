<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Questa è la jsp che ti permette di creare una nuova Thing </h1>
	<form action="Thing" method="post">
		<h3>Inserire nome thing: <input type="text" name="thingName" placeholder="inserire nome thing"></h3>
		<select  name="numeroUscite">
  				<option value="2">2</option>
  				<option value="4">4</option>
  				<option value="8">8</option>
  				<option value="16">16</option>
 				 <option value="32">32</option> 
			</select>		
		<button type ="submit" value="sendDataForInsert" name="operation">Crea</button><br>
	</form>
</body>
</html>