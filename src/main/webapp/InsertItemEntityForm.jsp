<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>------- Tipologie Disponibili ----------</p>
	<p>
		<jsp:include page="/ItemMenu">
     		<jsp:param name="mode" value="visualizzaItem"/>
     	</jsp:include>
	</p>
	<form action="ItemEntity" method="post">
		<p>Seriale: <input type="text" name="seriale" placeholder="seriale"></p>
		<p>Consumo energetico: <input type="text" name="consumo_energetico" placeholder="Consumo energetico"></p>
		<p>Id Room: <input type="text" name="roomId" placeholder="Room Id"></p>
		<p>Id Tipologia Item: <input type="text" name="idItemType" placeholder="Id Tipologia Item"></p>
		<p>Id Thing: <input type="text" name="thingId" placeholder="Id Thing"></p>
		<p>
			<button type = "submit" value = "Insert" name = "mode">Registra</button>
		</p>
		 
	</form>
</body>
</html>