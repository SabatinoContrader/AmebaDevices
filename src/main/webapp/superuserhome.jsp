<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>superuserhome</title>
</head>
<body>
	<div style="background-color: black" width="195">
		<img
			src="https://contrader.it/wp-content/themes/contrader-it/images/logo_white.svg"
			width="192" alt="15">
	</div>
	<h1>Seleziona l'operazione che vuoi effettuare</h1>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/add-user.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=InsertForm"
			style="font-size: x-large; text-decoration: none">Inserisci nuovo
			customer </a></br>
	</div>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/multy-user.png"
			style="width: 5%; padding-right:2%; "> <a href="Customer?mode=Read"
			style="font-size: x-large; text-decoration: none">Visualizza i
			customers</a>
	</div>
	</br>
	<div style="display: flex; align-items: center;">
		<img src="http://cdn.onlinewebfonts.com/svg/img_244280.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=UpdateForm"
			style="font-size: x-large; text-decoration: none">Modifica un
			customer</a>
	</div>
	</br>
	<div style="display: flex; align-items: center;">
		<img src="http://simpleicon.com/wp-content/uploads/remove-user.png"
			style="width: 5%; padding-right:2%;"> <a href="Customer?mode=DeleteForm"
			style="font-size: x-large; text-decoration: none">Elimina un
			customer</a> </br>
	</div>
	<jsp:include page="HeaderLogout.jsp"></jsp:include>
</body>
</html>