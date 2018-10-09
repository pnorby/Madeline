<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <table>
    <c:forEach var="user" items="${users}">
        <tr><td style="border:solid">${user.firstName}</td><td style="border:solid">${user.lastName}</td><td style="border:solid">${user.id}</td><td style="border:solid">${user.email}</td></tr>
    </c:forEach>
    </table>

    <form action="searchUser" method="GET">
        <input type="text" name="searchTerm">
        <button type="submit">ENTER</button>
    </form>
        <c:choose>
        <c:when test="${initial}">
        </c:when>
        <c:when test="${initial == false}">

            <h1>Results</h1>            
            <table>
                <c:forEach var="theUser" items="${searchedUsers}">
                <tr><td style="border:solid">${theUser.firstName}</td><td style="border:solid">${theUser.lastName}</td><td style="border:solid">${theUser.id}</td><td style="border:solid">${theUser.email}</td></tr>
                </c:forEach>
            </table>
        </c:when>
        </c:choose>

</div>

</body>
</html>
