<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="container" class="container">
    <div id="main_content">

        <div id="tripName" class="row">
            <h1 id="tripHeader">${trip.tripName}</h1>
        </div>
        <div class="row">
            <p>Location: ${trip.location.locationName}</p>
            <br/>
            <p>Starts: ${trip.tripStartDate}</p>
            <br/>
            <p>Ends: ${trip.tripEndDate}</p>

        </div>

        <%@include file="/tripWeather.jsp"%>

        <div id="tripInformation">
            <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="packingList">
                <h2 class="infoLabel">Packing List</h2>
            </div>

            <div style="border:solid black 1px" class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="messageBoard">
                <c:forEach var="message" items="${tripMessages}">
                    <div class="row">
                        <c:choose>
                            <c:when test="${message.user.userid eq user.userid}">
                                <div class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                <p class="sentP"><span class="userSent">${message.messageBody}</span></p>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
                                <div style="float:right" class="col-lg-9 col-md-9 col-sm-9 col-xs-9">
                                    <p class="receivedP"><span class="userReceived">${message.messageBody}</span></p>
                                </div>

                            </c:otherwise>
                        </c:choose>
                    </div>

                </c:forEach>
                <br />
                <br />
                <br />
                <form method="POST" action="messageController?tripNo=${trip.tripid}&uNo=${user.userid}">
                    <label for="theMessage">Message</label>
                    <input type="text" id="theMessage" name="tripMessage"/>
                    <button type="submit">POST</button>
                </form>
            </div>

            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12" id="attendees">
                <c:forEach var="person" items="${attendees}">
                    <div class="row">
                        <p class="attending">${person.firstName} ${person.lastName}</p>
                    </div>
                </c:forEach>
            <h2 class="infoLabel">Attendees</h2>

            </div>

        </div>

    </div>
        <br/>
        <br/>
        <br/>

</div>
</div>
