<<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Home</title>
</head>
<body>
<h1>${headerMessage}</h1>

<form action="#" method="POST" th:action="@{/addUser}" th:object="${user}">
  <table>
    <tr>
      <td><form:label path="name">Name</form:label></td>
      <td><form:input path="name"/></td>
    </tr>
    <tr>
      <td><form:label path="age">Age</form:label></td>
      <td><form:input path="age"/></td>
    </tr>
    <tr>
      <td><input type="submit" value="Submit"/></td>
    </tr>
  </table>
</form>

</body>
</html>