<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Users</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/user/create">Create a new user</a></li>
    </ul>
</nav>

<h1>List of Users</h1>

<table>
    <thead>
    <tr>
        <th>name</th>
        <th>Role</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><a href="/user/${user.id}">${user.name}</a></td>
            <td>
                <c:forEach items="${user.roleList}" var="role">
                    ${role.roleName}
                </c:forEach>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>