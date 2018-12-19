<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Plan a trip!</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="CSS/homeTwo.css" rel="stylesheet">
</head>
<body>
<c:choose>
<c:when test="${loggedIn}">
<%@include file="/loggedIn.jsp"%>
    <div class="container">
    <H1>Plan Your Trip!</H1>
    <br />
    <br />
    <form method="POST" action="addTripController">
        <label for="tName">Trip Name:</label>
        <input type="text" id="tName" name="tripName"/>
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
    </body>
    </html>
</c:when>
<c:otherwise>
    <H1>You must log in</H1>
    </body>
</c:otherwise>

</c:choose>
</div>
</body>
</html>
