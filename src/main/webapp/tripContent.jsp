<div id="container" class="container">
    <div id="main_content">

        <div id="tripName">
            <h1 id="tripHeader">${trip.name}</h1>
        </div>
        <div id="tripWeather">
            <%@include file="/tripWeather.jsp"%>
        </div>
        <div id="tripInformation">
            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-12" id="packingList">
                <p>packing list</p>
            </div>

            <div class="col-lg-5 col-md-5 col-sm-5 col-xs-12" id="messageBoard">
                <p>message board</p>
            </div>

            <div class="col-lg-2" id="attendees">
            <p>attendees</p>
            </div>
        </div>

    </div>
</div>