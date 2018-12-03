<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="tripWeather">
<c:forEach var="newRow" items="${weatherRows}">
    <div class="row">
    <c:forEach var="day" items="${newRow}">
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" name="tripDay" id="${day}">
            <p>${day}</p>
        </div>
    </c:forEach>
    </div>
</c:forEach>
</div>