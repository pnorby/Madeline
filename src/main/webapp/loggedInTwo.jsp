<nav class="navbar navbar-inverse" id="theNav">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavBar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavBar">
            <ul class="nav navbar-nav">
                <li><a href="index.html">Home</a></li>
                <li><a href="directToAdmin">Admin</a></li>
                <li><a href="planTripController">Plan a Trip</a></li>

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Trips<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="trip" items="${userTrips}">
                            <li><a class="dropdown-item" href="tripController?select=${trip.tripid}">${trip.tripName}</a></li>
                        </c:forEach>
                        <!--<li><a href="#">HTML</a></li>
                        <li><a href="sqlSamples.html">SQL</a></li> -->
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">

            </ul>
        </div>
    </div>
</nav>
