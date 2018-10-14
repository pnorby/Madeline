$(document).ready(){
	var dates = $(.tripDay)
	
	for (var i = 0; i < dates.length; i++){
		var date = dates[i].id.toString;
		var theLocation = $(#thePlace).id.toString;
		
		var xhr = new XMLHttpRequest();
		var firstUrl = "http://api.geonames.org/postalCodeSearchJSON?formatted=true&postalcode=" + theLocation + "&maxRows=1&username=pnorby&style=full";
		var lat;
		var lng;
		var city = "";
	
		xhr.open("get", firstUrl);
	    
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
			
				var result = JSON.parse(xhr.responseText);
				console.log(result);
				var lat = result.postalCodes[0].lat;
				var lng = result.postalCodes[0].lng;
				var city = result.postalCodes[0].placeName;
			
				var secondUrl = "http://api.geonames.org/findNearByWeatherJSON?formatted=true&lat=" + lat + "&lng=" + lng + "&username=pnorby&style=full";
				var secondXhr = new XMLHttpRequest();
				secondXhr.open("get", secondUrl);
				secondXhr.onreadystatechange = function(){
					if(secondXhr.readyState == 4 && secondXhr.status == 200){
				    
					var secondResult = JSON.parse(secondXhr.responseText);
					var wind = secondResult.weatherObservation.windSpeed;
					var temp = secondResult.weatherObservation.temperature;
					
					processResults(city, temp, wind);					
					}
				}
			}
			secondXhr.send(null);			
		}	
		xhr.send(null);
	}
}
function processResults(){
	//process the weather results here	
}