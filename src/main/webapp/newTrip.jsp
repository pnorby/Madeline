<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="GET" action="adminAddTrip">
    <label for="tName">Trip Name:</label>
    <input type="text" id="tName" name="tripName"/>
    <br/>
    <label for="tTripCreator">Trip Creator (User Id):</label>
    <input type="text" id="tTripcreator" name="userId"/>
    <br/>
    <label for="tStartDate">Start Date</label>
    <input type="text" id="tStartDate" name="startDate"/>
    <br/>
    <label for="tEndDate">End Date</label>
    <input type="text" id="tEndDate" name="endDate"/>
    <br/>
    <label for="tLocation">Location:</label>
    <select id="tLocation" name="tripLocation">
        <c:forEach var="loc" items="${locations}" >
            <option value="${loc.id}">${loc.locationName}</option>
        </c:forEach>
    </select>
    <br/>
    <button type="submit">Submit</button>
</form>