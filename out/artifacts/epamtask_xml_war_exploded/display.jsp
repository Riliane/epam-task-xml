<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Results</title>
</head>
<body>
    <table><tr>
        <td>Name</td>
        <td>Price</td>
        <td>Description</td>
        <td>Calories</td>
    </tr>
        <c:set var="start" value="${((page-1)*resultsPerPage)}" />
        <c:set var="end" value="${page*resultsPerPage-1}" />
        <c:forEach var="result" items="${data}" begin="${start}" end="${end}">
        <tr>
            <td>${result.name}</td>
            <td>${result.price}</td>
            <td>${result.description}</td>
            <td>${result.calories}</td>
        </tr>
        </c:forEach>
    </table>
    <c:if test="${page != 1}">
        <a href="Controller?page=${page - 1}">Previous</a>
    </c:if>
    <c:forEach begin="1" end="${pages}" var="i">
        <c:choose>
            <c:when test="${page eq i}">
                ${i}
            </c:when>
            <c:otherwise>
                <a href="Controller?page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${page lt pages}">
        <a href="Controller?page=${page + 1}">Next</a>
    </c:if>

</body>
</html>
