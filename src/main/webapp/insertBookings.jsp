<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pCarpet.model.Prenotazione"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>



<link href="/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/pcarpet.css">

</head>
<body>

	<h2><center>Inserisci la tua prenotazione</center></h2>
 
 </br>
 
	<form width="400" class="form-signin" action="/HomePrenotazione/showPrenotazione" method="post">
     
     <div id="container">
     <div id="left">
     <table class="border rcorners" id="mytable">	
	
		
	
	<tr>
        
         <th>
             ID UTENTE
         </th>

         <th>
             ID ASSET
         </th>
         
         <th>
             ORA INIZIO
         </th>
         
         <th>
             ORA FINE
         </th>
         
         <th>
         	EFFETTUA MODIFICHE
          </th>

     </tr>
	
        <c:forEach items="${listPrenotazione}" var="prenotazioni">
     	
         <td>
             
             	<c:out value="${prenotazioni.iduser}"></c:out>
             
         </td>
		
		<td>
            <c:out value="${prenotazioni.idasset}"></c:out>
         </td>
         
         <td>
            <c:out value="${prenotazioni.orainizio}"></c:out>
         </td>

         <td>
             <c:out value="${prenotazioni.orafine}"></c:out>
         </td>

         
         
          <td>
          <a class="btn lg btn-primary btn-block"
			href="/HomePrenotazione/showPrenotazione?choice=update&idU=${prenotazioni.iduser}&idA=${prenotazioni.idasset}&idO=${prenotazioni.orainizio}">Modifica</a>
         </td>
         
         <%--
         <td>
             <a class="btn btn-lg btn-primary btn-block"
			href="/HomeUser/showUsers?choice=delete&id=${user.iduser}">Elimina</a>
         </td> --%>
		
		
     	</tr>
     	</c:forEach>	
     
     
	</table>
    </div>
    </div>
    
    </br>
    
     
  	 <div id="right">
  	 
     <table id="mytable">
     	<tr><td>
     	<h4>ID UTENTE: <input type = "text" id = "user" name ="iduser" placeholder = "Inserisci ID utente" required autofocus></h4>
     	</td>
     	
     	<td>
     	<h4>ID ASSET: <input type = "text" id = "user" name ="idasset" placeholder = "Inserisci ID asset" required autofocus></h4>
     	</td>
     	
     	<td>
     	<h4>ORA INIZIO: <input type="datetime-local" name="orainizio" required autofocus></h4>
     	</td>
     	
     	<td>
     	<h4>ORA FINE: <input type="datetime-local" name="orafine" required autofocus></h4>
		</td></tr>
			
		
		</table>
	<table border="0">
		<tr>
		<td>
		<button class="btn lg btn-primary" type="submit" value="insert" name="choice">Inserisci</button>
		</td>
		
	    <td>
		<a class="btn lg btn-primary" 
		href="/HomePrenotazione/showPrenotazione?choice=indietroManagementBookings">Indietro</a></br>
		</td>
		</tr>
     </table>
     
    </div>
  
     </br>
     
     
     
     
     <c:choose>
     
			<c:when test="${feedback == 'success'}">
				<div class="alert alert-success">
    				<strong>Success!</strong> Registrazione effettuata con successo.
  				</div>
			</c:when>
			
			<c:when test="${feedback == 'wrong'}">
				<div class="alert alert-danger">
    				<strong>Error!</strong> Prenotazione già presente o data errata, riprova.
  				</div>
			</c:when>
			
     </c:choose>
     
     
     </form>

</body>
</html>