<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>-------- Modifica Item ----------------</p>
	<p>
		<form action = "ItemMenu" method = "POST">
         	<p>id: <input type = "text" name = "id"  placeholder="id"></p>
         	<p>Marca: <input type = "text" name = "marca" placeholder="marca" /></p>
         	<p>Modello: <input type = "text" name = "modello"  placeholder="modello"/></p>
         	<p>Categoria: <input type = "text" name = "categoria"  placeholder="categoria"/></p>
         	<p>Descrizione: <textarea rows="4" cols="50" name="descrizione"></textarea></p>
         	<p><button type = "submit" value = "Modifica" name = "mode">Modifica</button></p>
    	</form>
	</p>
</body>
</html>