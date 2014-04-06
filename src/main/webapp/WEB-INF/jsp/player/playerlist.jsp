<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ include file="/WEB-INF/jsp/include/head.jsp" %>
</head>
<body>
<div class="container">
    <h1>Player list</h1>

    <form action="playerSave" method="post">
        <div class="form-group">
            <input type="hidden" name="id">
            <label for="username">Player Name</label>
            <input type="text" id="username" name="username"/>
        </div>
        <div class="form-group">
            <label for="nickname">Nickname</label>
            <input type="text" id="nickname" name="nickname"/>
        </div>
            <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <table class="table">
        <thead>
            <tr><th>Username</th><th>Nickname</th><th></th></tr>
        </thead>
        <tbody>
        <c:forEach var="player" items="${playerList}">
            <tr>
                <td>${player.username}</td>
                <td>${player.nickname}</td>
                <td><input type="button" value="delete" onclick="window.location='playerDelete?id=${player.id}'"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>