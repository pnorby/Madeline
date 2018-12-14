<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="container" class="container">
    <div id="main_content">

        <div id="tripName">
            <h1 id="tripHeader">${trip.tripName}</h1>
        </div>

        <%@include file="/tripWeather.jsp"%>

        <div id="tripInformation">
            <div class="row">
            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-12" id="packingList">
                <p>packing list</p>
            </div>

            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-12" id="messageBoard">
                <c:forEach var="message" items="${tripMessages}">
                    <div class="row">
                        <c:choose>
                            <c:when test="${message.user.userid eq user.userid}">
                                <p class="sentP"><span class="userSent">${message.messageBody}</span></p>
                            </c:when>
                            <c:otherwise>
                                <p class="receivedP"><span class="userReceived">${message.messageBody}</span></p>
                            </c:otherwise>
                        </c:choose>
                    </div>

                </c:forEach>
                <form method="POST" action="messageController?tripNo=${trip.tripid}&uNo=${user.userid}">
                    <label for="theMessage">Message</label>
                    <input type="text" id="theMessage" name="tripMessage"/>
                    <button type="submit">POST</button>
                </form>
            </div>

            <div class="col-lg-2" id="attendees">
            <p>attendees</p>
            </div>
            </div>
        </div>

    </div>
</div>
