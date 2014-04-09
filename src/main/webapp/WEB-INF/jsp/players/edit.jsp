<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring-form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <%@ include file="/WEB-INF/jsp/include/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/include/navbar.jsp" %>
<div class="container">
    <h1>Add player</h1>

    <spring-form:form method="POST" modelAttribute="player" class="form-horizontal">
    <fieldset>
        <spring-form:hidden path="id" name="id"/>
        <div class="control-group">
            <label class="control-label" for="firstName">First name:</label>
            <div class="controls">
                <spring-form:input path="firstName" name="firstName"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="lastName">Last name:</label>
            <div class="controls">
                <spring-form:input path="lastName" name="lastName"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="nickName">Nickname</label>
            <div class="controls">
                <spring-form:input path="nickName" name="nickName"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="phone">Mobile:</label>
            <div class="controls">
                <spring-form:input path="phone" name="phone"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="email">Email:</label>
            <div class="controls">
                <spring-form:input path="email" name="email"/>
            </div>
        </div>
        <br/>
        <button type="submit" class="btn btn-primary">Update</button>
    </fieldset>
    </spring-form:form>
</div>
</body>
</html>