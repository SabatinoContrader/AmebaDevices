<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crea il tuo building</title>
</head>
<body>
	<div>
     <form action = "CreateBuilding" method= "post">
     <h3>Indirizzo del building: <input type = "text" id = "indirizzoBuilding" name ="indirizzo" placeholder = "Inserisci indirizzo del building"></h3>
     <h3>Interno del building: <input type = "text" id = "internoBuilding" name ="interno" placeholder = "Inserisci interno del building"></h3>
     <h3>Città del building: <input type = "text" id = "cittàBuilding" name ="città" placeholder = "Inserisci città del building"></h3>
     <h3>Cap del building: <input type = "text" id = "capBuilding" name ="cap" placeholder = "Inserisci cap del building"></h3>
     <button type = "submit" value = "Login" name = "pulsante">Crea</button><br>
     <p>
     <a href="BuildingServlet?richiesta=goBack"> Torna alla gestione dei building </a>
     </p>
     </form>
   </div>
</body>
</html>