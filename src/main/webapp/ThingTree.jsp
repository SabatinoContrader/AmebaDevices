<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-xs-10">
			<c:forEach var="floor" items="${buildingTree.getAllFloors()}">
				<div class="row">
					<div class="col-xs-2">${floor.getNomeFloor()}</div>
					<div class="col-xs-10">
						<c:forEach var="room" items="${buildingTree.getRoomsByFloor(floor.getId())}">
							<div class="row">
								<div class="col-xs-1">${room.getNomeRoom()}</div>
								<div class="col-xs-11">
									<c:forEach var="item" items="${buildingTree.getItemsByRoom(room.getId())}">
										<div class="col-xs-12">${item.getId()}</div>
									</c:forEach>
								</div>
							</div>						
						</c:forEach>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="col-xs-2"></div>
	</div>
</body>
</html>