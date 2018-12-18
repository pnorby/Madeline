<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="GET" action="adminUpdateTrip">
    <label for="tName">Trip Name:</label>
    <input type="text" id="tName" name="tripName" placeholder="${theTrip.tripName}"/>
    <br/>
    <label for="tTripCreator">Trip Creator (User Id):</label>
    <input type="text" id="tTripcreator" name="userId" placeholder="${theTrip.tripCreator}"/>
    <br/>
    <label for="tStartDate">Start Date</label>
    <input type="text" id="tStartDate" name="startDate" placeholder="${theTrip.tripStartDate}"/>
    <br/>
    <label for="tEndDate">End Date</label>
    <input type="text" id="tEndDate" name="endDate" placeholder="${theTrip.tripEndDate}"/>
    <br/>
    <label for="tLocation">Location:</label>
    <select id="tLocation" name="tripLocation" placeholder="${theTrip.location.locationName}">
        <c:forEach var="loc" items="${locations}" >
            <option value="${loc.id}">${loc.locationName}</option>
        </c:forEach>
    </select>
    <input type="hidden" value="${theTrip.tripid}" name="tripId"/>
    <br/>
    <button type="submit">Submit</button>
</form>
