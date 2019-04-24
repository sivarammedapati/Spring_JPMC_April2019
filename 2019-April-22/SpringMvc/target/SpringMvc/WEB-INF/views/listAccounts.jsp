<%--
  Created by IntelliJ IDEA.
  User: anilj
  Date: 4/23/2019
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accounts</title>
</head>
<body>
    <h2>Accounts</h2>

    <c:forEach items="${accounts}" var="acc">
        <div>
            <p>ID: ${acc.id}</p>
            <p>Name: ${acc.name}</p>
            <p>Balance: ${acc.balance}</p>
        </div>
    </c:forEach>


</body>
</html>
