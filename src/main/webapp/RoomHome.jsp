<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RoomHome</title>
</head>
<body>
     <h1>Benvenuto <%= request.getSession().getAttribute("utente")%></h1>
     <h2>------- MENU ROOMS -------</h2>
	 
	 <h3>1. Inserisci una room</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="InsertForm" name="richiesta">
     </form>
     
	 <h3>2. Visualizza tutte le Room</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="ReadRoom" name="richiesta">
     </form>

     <h3>3. Elimina un prodotto</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="DeleteForm" name="richiesta">
     </form>

     <h3>4. Ricerca un prodotto</h3>
     <form action="RoomServlet" method="get">
     <input type="submit" value="SearchForm" name="richiesta">
     </form>

     <h3>5.logout<h3>
     <form action="Logout" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>