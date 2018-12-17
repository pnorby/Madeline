$(document).ready(function(){

    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=User";
        xhr.open("get", firstUrl);

                xhr.onreadystatechange = function () {

                    if (xhr.readyState == 4 && xhr.status == 200) {

                        var result = xhr.responseText;
                        var holder = $("#adminData");
                        holder.append(result);
                        var table = $("#allRecords")



                    }
                }
        xhr.send(null);
    });

function totalUsers(){
    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=User";
    xhr.open("get", firstUrl);

    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4 && xhr.status == 200) {

            var result = xhr.responseText;
            var holder = $("#adminData");
            $("#allRecords").remove();
            holder.append(result);


        }
    }
    xhr.send(null);
};


function totalLocations() {
    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=Location";
    xhr.open("get", firstUrl);

    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4 && xhr.status == 200) {

            var result = xhr.responseText;
            var holder = $("#adminData");
            $("#allRecords").remove();
            holder.append(result);


        }
    }
    xhr.send(null);

};

function totalTrips() {
    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=Trip";
    xhr.open("get", firstUrl);

    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4 && xhr.status == 200) {

            var result = xhr.responseText;
            var holder = $("#adminData");
            $("#allRecords").remove();
            holder.append(result);


        }
    }
    xhr.send(null);

};