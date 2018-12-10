$(document).ready(function(){

    var dates = $(".tripDay");
    var latLonServiceCalled = false;
    var weatherServiceCalled = false;
    console.log(dates.length);

    if(dates.length !== 0){
        var i = 0;
        var lengthDates = dates.length;

        while(i < lengthDates){
            var date = dates[i].id;
            var selectedDay = dates[i];
            var dayInfo = "";
            var zipCode;
            var order;
            var weatherParms;

                if (date === "outOfRange") {
                    var noWeather = $("<p>");
                    noWeather.Text = "Date must be less than 16 days in the future";
                    selectedDay.append(noWeather);
                    console.log("made it into out of range");
                    i++;
                } else {
                    dayInfo = selectedDay.id;
                    weatherParms = dayInfo.split("-");
                    order = weatherParms[0];
                    zipCode = weatherParms[1];
                    console.log("made it into else1");
                    console.log(order);
                    console.log(zipCode);

                    var xhr = new XMLHttpRequest();
                    var firstUrl = "http://api.geonames.org/postalCodeSearchJSON?postalcode=" + zipCode + "&maxRows=10&username=pnorby";
                    var lat;
                    var lng;
                    var city = "";

                    xhr.open("get", firstUrl);

                    xhr.onreadystatechange = function () {

                        if (xhr.readyState == 4 && xhr.status == 200) {

                            var result = JSON.parse(xhr.responseText);
                            console.log(result);
                            var lat = result.postalCodes[0].lat;
                            lat = Math.round(lat);
                            console.log(lat);

                            var lng = result.postalCodes[0].lng;
                            lng = Math.round(lng);
                            console.log(lng);
                            var city = result.postalCodes[0].placeName;

                            var secondUrl = "https://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lng + "&appid=62768ee3cbbc1b180d8a1bba286f9929";
                            var secondXhr = new XMLHttpRequest();
                            secondXhr.open("get", secondUrl);
                            secondXhr.onreadystatechange = function () {
                                if (secondXhr.readyState == 4 && secondXhr.status == 200) {

                                    var secondResult = JSON.parse(secondXhr.responseText);
                                    var returnedDays = secondResult.List
                                    //var dayNeeded = returnedDays[order]
                                    console.log(secondResult);


                                }
                            }
                            secondXhr.send(null);
                        }

                    }

                    xhr.send(null);
                    i = dates.length;
                }
        }
    }
});