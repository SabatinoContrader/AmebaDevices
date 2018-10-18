<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items</title>
</head>
<body>
<p>------------ Items ---------------</p>
<p>
	<table style="width:100%">
		<tr>
    		<th>id</th>
    		<th>Categoria</th> 
    		<th>Marca</th>
    		<th>Modello</th>
    		<th>Descrizione</th>
  		</tr>
		<c:forEach items="${items}" var="item">
    		<tr>
    			<td><c:out value = "${item.getId()}"/></td>      
        		<td><c:out value = "${item.getCategoria()}"/></td>
        		<td><c:out value = "${item.getMarca()}"/></td>
        		<td><c:out value = "${item.getModello()}"/></td>
        		<td><c:out value = "${item.getDescrizione()}"/></td>
    		</tr>
		</c:forEach>
	</table>
</p>
<p>
	<a href="ItemMenu?mode=MainMenu">Torna indietro </a>
</p>
</body>
</html>