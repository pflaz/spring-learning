<%--
  Created by IntelliJ IDEA.
  User: Pawel
  Date: 2018-09-05
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Event registration</h1>
    <form action="register" method="post">
        <input name="firstName" placeholder="first name" /><br />
        <input name="lastName" placeholder="last name"><br />
        <input type="submit" value="Register" />
    </form>
    <a href="show">Print participants</a>
</body>
</html>
