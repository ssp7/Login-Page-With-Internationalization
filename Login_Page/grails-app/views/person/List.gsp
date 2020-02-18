<%--
  Created by IntelliJ IDEA.
  User: spatel
  Date: 2/17/2020
  Time: 6:47 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<g:each in = "${login_page.Person}" status = "i">
    <p>Index: ${i}</p>
    <p>First Name: ${it.firstName}</p>
    <p>Last Name: ${it.lastName}</p>
</g:each>
</body>
</html>