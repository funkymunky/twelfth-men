<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ include file="/WEB-INF/jsp/include/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
<div class="container">
    <h1>Add player</h1>

    <form action="playerSave" method="post">
        <input type="hidden" name="id">
        <div class="form-group">
            <label for="firstName">First name:</label>
            <input type="text" id="firstName" name="firstName"/>
        </div>
        <div class="form-group">
            <label for="lastName">Last name:</label>
            <input type="text" id="lastName" name="lastName"/>
        </div>
        <div class="form-group">
            <label for="nickName">Nickname</label>
            <input type="text" id="nickName" name="nickName"/>
        </div>
        <div class="form-group">
            <label for="phone">Mobile:</label>
            <input type="text" id="phone" name="phone"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email"/>
        </div>
            <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>