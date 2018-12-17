<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="POST" action="adminAddTrip">
    <label for="tName">Trip Name:</label>
    <input type="text" id="tName" name="tripName"/>
    <label for="tStartDate">Start Date</label>
    <input type="text" id="tStartDate" name="startDate"/>
    <label for="tEndDate">End Date</label>
    <input type="text" id="tEndDate" name="endDate"/>
    <label for="tLocation">Location:</label>
    <select id="tLocation" name="tripLocation">
        <c:forEach var="loc" items="${locations}" >
            <option value="${loc.id}">${loc.locationName}</option>
        </c:forEach>
    </select>
    <br/>
    <button type="submit">Submit</button>
</form>