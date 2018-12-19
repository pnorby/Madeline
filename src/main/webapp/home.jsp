<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="JsFiles/homeJS.js" type="text/javascript" charset="utf-8"></script>


    <!-- Custom styles for this template -->
    <link href="CSS/homeTwo.css" rel="stylesheet">

</head>
<body>
<c:choose>
    <c:when test="${loggedIn}">
<%@include file="/loggedInTwo.jsp"%>

<div class="container">
    <div id="main_content">
        <h1>Welcome</h1>


        <c:choose>
            <c:when test="${hasTrips}">
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="homeAccordion">
                    <h2>My Trips</h2>
                    <div id="accordion">

                        <c:forEach var="trip" items="${userTrips}">
                            <h3>${trip.tripName}</h3>
                            <div>
                                <p>${trip.location.locationName}</p>
                                <br />
                                <p>Starts: ${trip.tripStartDate}</p>
                                <br />
                                <p>Ends: ${trip.tripEndDate}
                                    <br />
                                <p>${trip.location.locationDescription}</p>
                            </div>
                        </c:forEach>


                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="homeAccordion">
                    <h2>My Trips</h2>
                    <div id="accordion">
                            <h3>You currently have no trips planned</h3>
                            <div>
                                <p>Use the links above to plan your first trip!</p>
                            </div>

                    </div>
                </div>
            </c:otherwise>
        </c:choose>



<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12" id="featuredLoc">
    <h2>Today's Featured Location</h2>
    <img src="images/mtrushmore.jpg"/>
    <p id="featureP">Mount Rushmore is a beautiful landmark in the Black Hills in Keystone, South Dakota. </p>
</div>
    </div>
</div>

</body>
    </c:when>
    <c:otherwise>
        <H1>You must log in</H1>
        </body>
    </c:otherwise>

</c:choose>

</html>
	  


