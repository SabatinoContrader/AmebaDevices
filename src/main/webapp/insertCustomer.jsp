<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Customer</title>
</head>
<body>
<h2>Inserisci il tuo Customer </h3>
<form action="Customer" method="post">
<h3>Nome: <input type = "text" id = "nome" name ="nome" placeholder = "Nome"></h3>
<h3>Cognome: <input type = "text" id = "cognome" name ="cognome" placeholder = "Cognome"></h3>
<h3>Data di Nascita: <input type = "date" id = "dataDiNascita" name ="dataDiNascita" placeholder = "Data di Nascita"></h3>
<h3>Email: <input type = "text" id = "email" name ="email" placeholder = "Email"></h3>
<h3>Username: <input type = "text" id = "username" name ="username" placeholder = "Username"></h3>
<h3>Password: <input type = "password" id = "password" name ="password" placeholder = "Password"></h3>
<input hidden name="mode" value="InsertDb">
<button> Registra </button>
</form>

</body>
</html>