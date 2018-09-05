<%--
  Created by IntelliJ IDEA.
  User: Pawel
  Date: 2018-09-05
  Time: 05:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>
    <h1>Shopping cart</h1>
    <form action="add" method="post">
        <input name="product" /><br />
        <input value="Add product" type="submit" />
    </form>
    <a href="print">Print products in console</a>
</body>
</html>
