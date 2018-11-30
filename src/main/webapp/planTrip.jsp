<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Plan a Trip!</title>
</head>
<body>
<H1>Plan Your Trip!</H1>
<br />
<br />
<form>
    <label>Trip Name:</label>
    <input type="text"/>
    <label>Start Date</label>
    <input type="text"/>
    <label>End Date</label>
    <input type="text"/>
    <label>Location:</label>
    <select>
        <c: foreach var="loc" items="${locations}" >
            <option value="${loc.id}">{loc.name}</option>
        </c:>
    </select>
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>
