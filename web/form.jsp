<%--
  Created by IntelliJ IDEA.
  User: hunlisong
  Date: 16/7/14
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/FormDoServlet" method="post">

    <input type="hidden" name="token" value="${token}"/>

    <input type="text" name="username"/>
    <input type="submit" value="提交">

</form>

</body>
</html>
