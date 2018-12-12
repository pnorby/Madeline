<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="planTripController">Plan a Trip</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    My Trips
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <c:forEach var="trip" items="${userTrips}">
                        <a class="dropdown-item" href="tripController?select=${trip.tripid}">${trip.tripName}</a>
                    </c:forEach>
                </div>
            </li>
        </ul>

    </div>
</nav>
