<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<h2>Here is a simple CRUD using Spring MVC and MongoDB.</h2>

<form action="player/save" method="post">
    <input type="hidden" name="id">
    <label for="username">Player Name</label>
    <input type="text" id="username" name="username"/>
    <br/>
    <label for="nickname">Nickname</label>
    <input type="text" id="nickname" name="nickname"/>
    <input type="submit" value="Submit"/>
</form>

<table border="1">
    <c:forEach var="player" items="${playerList}">
        <tr>
            <td>${player.username}</td><td><input type="button" value="delete" onclick="window.location='player/delete?id=${player.id}'"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>