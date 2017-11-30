<%--
  Created by IntelliJ IDEA.
  User: Nana
  Date: 27.11.2017
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="Controller" method="get">
    <input type="radio" name="parser" value="sax">SAX<br>
    <input type="radio" name="parser" value="stax">StAX<br>
    <input type="radio" name="parser" value="dom">DOM<br>
    <input type="submit"/>
</form>
</body>
</html>
