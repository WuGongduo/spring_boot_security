<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new user</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new user</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="name">name</label>
        <input type="name" name="name" id="name" value="${form.name}" required autofocus/>
    </div>
    <div>
        <label for="password">Password</label>
        <input type="password" name="password" id="password" required/>
    </div>
    <div>
        <label for="passwordRepeated">Repeat</label>
        <input type="password" name="passwordRepeated" id="passwordRepeated" required/>
    </div>
    <div>
        <label for="role">Role</label>
        <select name="role" id="role" required>
            <option>USER</option>
            <option>ADMIN</option>
        </select>
    </div>
    <%--<form:form method="post" modelAttribute="form">--%>
        <form:errors path="*" class="has-error" />
    <%--</form:form>--%>
    <button type="submit">Save</button>
    <%--<spring:hasBindErrors name="form">--%>
    <%--<c:forEach var="error" items="${errors.allErrors}">--%>
    <%--<b><spring:message message="${error}" /></b>--%>
    <%--<br />--%>
    <%--</c:forEach>--%>
    <%--</spring:hasBindErrors>--%>

</form>

</body>
</html>