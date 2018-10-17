<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ItemMenu" method="post">
		<p>
			Marca: <input type="text" name="marca" placeholder="marca">
		</p>
		<p>
			Modello: <input type="text" name="modello" placeholder="modello">
		</p>
		<p>
			Categoria: <input type="text" name="categoria" placeholder="categoria">
		</p>
		<p>
			Descrizione: <textarea rows="4" cols="50" name="descrizione"></textarea>
		</p>
		<p>
			<button type = "submit" value = "Censimento" name = "mode">Censisci</button>
		</p>
		 
	</form>
</body>
</html>