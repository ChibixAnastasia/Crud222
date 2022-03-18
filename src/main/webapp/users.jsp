<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users</title>
</head>
<body>
<a href="/users">TABLE</a>

<h1>USERS</h1>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
        <th>update</th>
        <th>delete</th>

    </tr>
    <tr th:each="user : ${list}">
        <td th:utext="${user.id}">id</td>
        <td th:utext="${user.name}">name</td>
        <td th:utext="${user.age}">age</td>
        <td><a th:href="@{update/{id}(id=${user.id})}">Update</a></td>
        <td><a th:href="@{delete/{id}(id=${user.id})}">Delete</a></td>
    </tr>
</table>

<form th:method="POST" th:action="@{/users}" th:object="${newuser}">
    <br/>
    <label for="name">Enter name:</label>
    <input type="text" th:field="*{name}" id="name"/>
    <br/>
    <label for="age">Enter age:</label>
    <input type="text" th:field="*{age}" id="age"/>
    <p><a href="/addUser">Create</a></p>
    <br/>

</form>



</body>
</html>