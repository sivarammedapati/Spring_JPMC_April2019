<%--
  Created by IntelliJ IDEA.
  User: anilj
  Date: 4/23/2019
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>Welcome to Spring MVC</h2>

    <p>Message: <%=request.getAttribute("fMsg")%> </p>

    <p>Message: ${fMsg}</p>
</body>
</html>
