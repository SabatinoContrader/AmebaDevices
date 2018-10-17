<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<h2>MODIFICA BUILDING</h2>
</head>
<body>
<div>
     <form action = "BuildingServlet" method= "get">
     <h3>Nuovo indirizzo del building (attuale:): <input type = "text" id = "indirizzoBuilding" name ="newindirizzo" placeholder = "Inserisci nuovo indirizzo del building"></h3>
     <h3>Nuovo interno del building (attuale:): <input type = "text" id = "internoBuilding" name ="newinterno" placeholder = "Inserisci nuovo interno del building"></h3>
     <h3>Nuova città del building (attuale:): <input type = "text" id = "cittàBuilding" name ="newcittà" placeholder = "Inserisci nuovo città del building"></h3>
     <h3>Nuovo Cap del building (attuale:): <input type = "text" id = "capBuilding" name ="newcap" placeholder = "Inserisci nuovo cap del building"></h3>
     <button type = "submit" value = "UpdateBuilding" name = "richiesta">Modifica</button><br>
     <p>
     <a href="BuildingServlet?richiesta=goBack"> Torna alla gestione dei building </a>
     </p>
     </form>
   </div>
</body>
</html>