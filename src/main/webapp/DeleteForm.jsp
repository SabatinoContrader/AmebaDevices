<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Inserisci l'id da cancellare</h3>
<form action="RoomServlet" method="post">

    <h2>ID ROOM<input type="text" name="id_room"></h2>
	 <input type="submit" value="DeleteRoom" name="richiesta">
	 </form>
</body>
</html>