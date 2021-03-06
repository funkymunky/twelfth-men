<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ include file="/WEB-INF/jsp/include/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
<div class="container">
    <h1>Player list</h1>
    <a href="/twelfth-men/players/add" class="btn btn-primary">Add player</a>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Nickname</th>
                <th>Name</th>
                <th>Contact No.</th>
                <th>Email</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="player" items="${playerList}">
            <tr>
                <td><a href="/twelfth-men/players/edit/${player.id}">${player.nickName}</a></td>
                <td>${player.firstName} ${player.lastName}</td>
                <td>${player.phone}</td>
                <td>${player.email}</td>
                <td>
                    <button type="button" class="btn btn-default" onclick="window.location='playerDelete?id=${player.id}'">Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>